exports.success = (res, message) => {
  res.status(200).json(message)
}

exports.error = (res, message) => {
  res.status(500).json(message)
}

exports.forbidden = (res) => {
  res.status(403).json({ msg: 'Permission denied' })
}

exports.errorMessages = (res, errors) => {
  const message = {}
  errors.forEach((err) => {
    message[err.param] = err.msg
  })
  res.status(500).json(message)
}
