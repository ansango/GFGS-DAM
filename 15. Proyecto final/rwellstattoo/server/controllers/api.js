const express = require('express')
const router = express.Router()
const responses = require('../utils/responses')
const passportConfig = require('../config/passport')

// Controllers
const authController = require('./auth')
const userController = require('./user')
const itemController = require('./item')
const appointmentController = require('./appointment')
const reqAppointmentController = require('./reqAppointment')

/* ------------------------------------------------------------------ */
//   Auth
/* ------------------------------------------------------------------ */
/**
 * @api {post} /api/auth/login Login an user into the system
 * @apiName Login
 * @apiGroup Auth
 * @apiSuccess (200)
 */

router.post('/auth/login', authController.login)

/**
 * @api {post} /api/auth/logout Finish user session
 * @apiName Logout
 * @apiGroup Auth
 * @apiSuccess (200)
 */

router.post('/auth/logout', authController.logout)

/* ------------------------------------------------------------------ */
//   User
/* ------------------------------------------------------------------ */
/**
 * @api {post} /api/user/register Create user
 * @apiName Register
 * @apiGroup User
 * @apiSuccess (200)
 */

router.post('/user/register', userController.register)

/**
 * @api {get} /api/user/user Get an user
 * @apiName Get user
 * @apiGroup User
 * @apiSuccess (200)
 */

router.get('/user', passportConfig.isAuthenticated, userController.getUser)

router.delete('/user/delete', userController.deleteUser)

/* ------------------------------------------------------------------ */
//   Item
/* ------------------------------------------------------------------ */
/**
 * @api {get} /api/testing
 * @apiName Testing
 * @apiGroup Item
 * @apiSuccess (200)
 */

router.get('/testing', itemController.testing)

/**
 * @api {post} /api/addItem
 * @apiName Add an item
 * @apiGroup Item
 * @apiSuccess (200)
 */

router.post('/addItem', itemController.addItem)

/**
 * @api {get} /api/getAllItems
 * @apiName Get all items
 * @apiGroup Item
 * @apiSuccess (200)
 */

router.get('/getAllItems', itemController.getAllItems)

/**
 * @api {get} /api/getItemById/:id
 * @apiName Get an item by ID
 * @apiGroup Item
 * @apiSuccess (200)
 */

router.get('/getItemById/:id', itemController.getItemById)

/**
 * @api {put} /api/updateItemById/:id
 * @apiName Update an item by ID
 * @apiGroup Item
 * @apiSuccess (200)
 */

router.post('/updateItemById/:id', itemController.updateItemById)

/**
 * @api {delete} /api/deleteItemById/:id
 * @apiName Delete an item by ID
 * @apiGroup Item
 * @apiSuccess (200)
 */

router.delete('/deleteItemById/:id', itemController.deleteItemById)

/**
 * @api {delete} /api/deleteAllItems
 * @apiName Delete all items
 * @apiGroup Item
 * @apiSuccess (200)
 */

router.delete('/deleteAllItems/', itemController.deleteAllItems)

/* ------------------------------------------------------------------ */
//   Appointment
/* ------------------------------------------------------------------ */

/**
 * @api {get} /api/appointment/testing
 * @apiName Testing
 * @apiGroup Appointment
 * @apiSuccess (200)
 */

router.get('/appointment/testing', appointmentController.testing)

/**
 * @api {post} /api/appointment/addAppointment
 * @apiName Add an Appointment
 * @apiGroup Appointment
 * @apiSuccess (200)
 */

router.post('/appointment/addAppointment', appointmentController.addAppointment)

/**
 * @api {get} /api/appointment/getAllAppointments
 * @apiName Get all Appointments
 * @apiGroup Appointment
 * @apiSuccess (200)
 */

router.get('/appointment/getAppointments', appointmentController.getAllAppointments)

/**
 * @api {get} /api/appointment/getAppointmentById/:id
 * @apiName Get an Appointment by ID
 * @apiGroup Appointment
 * @apiSuccess (200)
 */

router.get('/appointment/getAppointmentById/:id', appointmentController.getAppointmentById)

/**
 * @api {put} /api/appointment/updateAppointmentById/:id
 * @apiName Update an Appointment by ID
 * @apiGroup Appointment
 * @apiSuccess (200)
 */

router.post('/appointment/updateAppointmentById/:id', appointmentController.updateAppointmentById)

/**
 * @api {delete} /api/appointment/deleteAppointmentById/:id
 * @apiName Delete an Appointment by ID
 * @apiGroup Appointment
 * @apiSuccess (200)
 */

router.delete('/appointment/deleteAppointmentById/:id', appointmentController.deleteAppointmentById)

/**
 * @api {delete} /api/appointment/deleteAllAppointments
 * @apiName Delete all Appointments
 * @apiGroup Appointment
 * @apiSuccess (200)
 */

router.delete('/appointment/deleteAllAppointments', appointmentController.deleteAllAppoinments)

/* ------------------------------------------------------------------ */
//   Request Appointment (by client)
/* ------------------------------------------------------------------ */

/**
 * @api {get} /api/request/testing
 * @apiName Testing
 * @apiGroup Request Appointment
 * @apiSuccess (200)
 */

router.get('/request/testing', reqAppointmentController.testing)

/**
 * @api {post} /api/request/addRequest
 * @apiName Add a Request Appointment
 * @apiGroup Request Appointment
 * @apiSuccess (200)
 */

router.post('/request/addRequest', reqAppointmentController.addRequest)

/**
 * @api {get} /api/request/getAllRequests
 * @apiName Get all Requests Appointment
 * @apiGroup Request Appointment
 * @apiSuccess (200)
 */

router.get('/request/getAllRequests', reqAppointmentController.getAllRequests)

/**
 * @api {get} /api/request/getRequestById/:id
 * @apiName Get a Request Appointment by ID
 * @apiGroup Appointment
 * @apiSuccess (200)
 */

router.get('/request/getRequestById/:id', reqAppointmentController.getRequestById)

/**
 * @api {delete} /api/request/deleteRequestById/:id
 * @apiName Delete a Request Appointment by ID
 * @apiGroup Request Appointment
 * @apiSuccess (200)
 */

router.delete('/request/deleteRequestById/:id', reqAppointmentController.deleteRequestById)

/* ------------------------------------------------------------------ */
//   Test
/* ------------------------------------------------------------------ */

/**
 * @api {get} /api/test Test Api
 * @apiName Test
 * @apiGroup Test
 * @apiSuccess (200)
 */

router.get('/test', (req, res) => {
  responses.success(res, { msg: 'Hello From api' })
})

// Export the server middleware
export default {
  path: '/api',
  handler: router
}
