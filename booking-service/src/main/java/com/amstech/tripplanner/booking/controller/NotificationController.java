package com.amstech.tripplanner.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amstech.tripplanner.booking.modal.request.NotificationCreateRequestModal;
import com.amstech.tripplanner.booking.modal.response.NotificationResponseModal;
import com.amstech.tripplanner.booking.service.NotificationService;



@RestController
@RequestMapping("/notification")
public class NotificationController {
	@Autowired
	private NotificationService notificationService;

	public NotificationController() {
		System.out.println("NotificationController : Object Created");
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> create(@RequestBody NotificationCreateRequestModal notificationCreateRequestModal) {

		System.out.println("Saveing Createting Notification with title: " + notificationCreateRequestModal.getTital());

		try {
			notificationService.create(notificationCreateRequestModal);
			return new ResponseEntity<Object>("Notifiaction Create SuccessFull", HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();
			return new ResponseEntity<Object>("Faield To Create Notifiaction due to : " +e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@RequestMapping(method = RequestMethod.PUT, value = "/mark-read", produces = "application/json")
	public ResponseEntity<Object> markRead(@RequestParam("id") Integer id) {

		System.out.println("Marking As Read on Notification with id: " + id);

		try {
			notificationService.markRead(id);
			return new ResponseEntity<Object>("Successfully  Mark As Read on Notification ", HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();
			return new ResponseEntity<Object>("Faield To Mark As Read on Notification : " +e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/byuser", produces = "application/json")
	public ResponseEntity<Object> findByUserId(@RequestParam("id") Integer id) {

		System.out.println("Marking As Read on Notification with id: " + id);

		try {
			List<NotificationResponseModal> notificationResponseModals = notificationService.findByUserId(id);
			return new ResponseEntity<Object>(notificationResponseModals, HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();
			return new ResponseEntity<Object>("Faield To find notification due to : " +e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
