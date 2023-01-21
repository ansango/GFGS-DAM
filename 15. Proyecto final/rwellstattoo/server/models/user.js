const mongoose = require('mongoose')
const bcrypt = require('bcrypt')

const userSchema = new mongoose.Schema({
  email: { type: String, unique: true },
  password: String,
  passwordResetToken: String,
  passwordResetExpires: Date,
  profile: {
    name: String,
    middlename: String,
    lastname: String,
    picture: String
  }
}, { timestamps: true })

/**
 * Password hash middleware.
 */
userSchema.pre('save', function save(next) {
  const user = this
  if (!user.isModified('password')) {
    return next()
  }
  bcrypt.hash(user.password, 10, (err, hash) => {
    if (err) {
      return next(err)
    }
    user.password = hash
    next()
  })
})

/**
 * Helper method for validating user's password.
 */
userSchema.methods.comparePassword = function comparePassword(candidatePassword, cb) {
  bcrypt.compare(candidatePassword, this.password, (err, isMatch) => {
    cb(err, isMatch)
  })
}

module.exports = mongoose.model('Users', userSchema)
