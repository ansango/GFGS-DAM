const Item = require('../models/item')
const responses = require('../utils/responses')

// Testing

exports.testing = function (req, res) {
  res.send('item TEST working...')
}

// Create an Item

exports.addItem = function (req, res) {
  const item = new Item(req.body)

  item.save((err) => {
    if (err) {
      return responses.error(res, { msg: err })
    }
    Item.find({})
      .then((item) => {
        return responses.success(res, { msg: 'item created', item: item })
      })
      .catch((err) => {
        return responses.error(res, { msg: err })
      })
  })
}

// Get All Items

exports.getAllItems = function (req, res) {
  Item.find({})
    .then((item) => {
      return responses.success(res, item)
    })
    .catch((err) => {
      return responses.error(res, { msg: err })
    })
}

// Get Item by ID

exports.getItemById = function (req, res) {
  Item.findById(req.params.id)
    .then((item) => {
      return responses.success(res, item)
    })
    .catch((err) => {
      return responses.error(res, { msg: err })
    })
}

// Update Item by ID

exports.updateItemById = function (req, res) {
  Item.findByIdAndUpdate(req.params.id, { $set: req.body })
    .then((item) => {
      return responses.success(res, item)
    })
    .catch((err) => {
      return responses.error(res, { msg: err })
    })
}

// Delete Item by ID

exports.deleteItemById = function (req, res) {
  Item.findByIdAndRemove(req.params.id)
    .then(() => {
      Item.find({})
        .then((items) => {
          return responses.success(res, items)
        })
        .catch((err) => {
          return responses.error(res, { msg: err })
        })
    })
    .catch((err) => {
      return responses.error(res, { msg: err })
    })
}

// Delete All Items

exports.deleteAllItems = function (req, res) {
  Item.deleteMany({})
    .then((items) => {
      return responses.success(res, items)
    })
    .catch((err) => {
      return responses.error(res, { msg: err })
    })
}
