const mongoose = require('mongoose')

const ItemSchema = new mongoose.Schema({
  name: String,
  description: String,
  price: Number,
  units: Number,
  total: this.price * this.units,
})

// Export the model
module.exports = mongoose.model('Item', ItemSchema)
