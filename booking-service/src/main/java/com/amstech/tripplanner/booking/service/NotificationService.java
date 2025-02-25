package com.amstech.tripplanner.booking.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amstech.tripplanner.booking.entity.Notification;
import com.amstech.tripplanner.booking.entity.Status;
import com.amstech.tripplanner.booking.entity.TripDetail;
import com.amstech.tripplanner.booking.entity.User;
import com.amstech.tripplanner.booking.modal.request.NotificationCreateRequestModal;
import com.amstech.tripplanner.booking.modal.response.NotificationResponseModal;
import com.amstech.tripplanner.booking.repo.NotificationRepo;
import com.amstech.tripplanner.booking.repo.StatusRepo;
import com.amstech.tripplanner.booking.repo.TripDetailRepo;
import com.amstech.tripplanner.booking.repo.UserRepo;

@Service
public class NotificationService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private TripDetailRepo tripDetailRepo;
	@Autowired
	private StatusRepo statusRepo;
	@Autowired
	private NotificationRepo notificationRepo;

	public NotificationService() {
		System.out.println("NotificationService : Object Created");
	}

	public void create(NotificationCreateRequestModal notificationCreateRequestModal) throws Exception {
		Optional<User> userOptional = userRepo.findById(notificationCreateRequestModal.getUserId());
		if (!userOptional.isPresent()) {
			throw new Exception("User is not Available with id : " + notificationCreateRequestModal.getUserId());
		}

		Optional<TripDetail> tripDetaileOptional = tripDetailRepo
				.findById(notificationCreateRequestModal.getTripDetailId());
		if (!tripDetaileOptional.isPresent()) {
			throw new Exception(
					"Trip Details is not Available with id : " + notificationCreateRequestModal.getTripDetailId());
		}

		Notification notificationExit = notificationRepo.findbyUserIdTripDetailId(userOptional.get().getId(),tripDetaileOptional.get());
		if (notificationExit != null) {
			throw new Exception("You already Send Request Of This Trip Detail id : "
					+ notificationCreateRequestModal.getTripDetailId());
		}

		int unReadId = 6;

		Optional<Status> statusOptional = statusRepo.findById(unReadId);
		if (!statusOptional.isPresent()) {
			throw new Exception("That Status is not Available with id : " + unReadId);
		}
		Notification notification = new Notification();
		notification.setUserId(userOptional.get().getId());
		notification.setTripDetail(tripDetaileOptional.get());
		notification.setMessage(notificationCreateRequestModal.getMessage());
		notification.setTitle(notificationCreateRequestModal.getTital());
		notification.setStatus(statusOptional.get());
		notification.setCreatedAt(new Date());
		notificationRepo.save(notification);

	}

	public void markRead(Integer id) throws Exception {
		Optional<Notification> notificationOptional = notificationRepo.findById(id);
		if (!notificationOptional.isPresent()) {
			throw new Exception("Notification is not Available with id : " + id);
		}
		int unReadId = 6;
		int readId = 7;

		Optional<Status> statusOptional = statusRepo.findById(readId);
		if (!statusOptional.isPresent()) {
			throw new Exception("That Status is not Available with id : " + readId);
		}
		
		if(notificationOptional.get().getStatus().getId() != unReadId) {
			throw new Exception("User alredy read notifiaction with id  : " + notificationOptional.get().getId());
		}
			
		
		Notification notification = notificationOptional.get();
		notification.setStatus(statusOptional.get());
		notificationRepo.save(notification);

	}
	public List<NotificationResponseModal> findByUserId(Integer id) throws Exception{
		Optional<User> userOptional = userRepo.findById(id);
		if (!userOptional.isPresent()) {
			throw new Exception("User is not Available with id : " + id);
		}
		
		List<Notification> notifications = notificationRepo.findbyUserId(id);
		
		if(notifications.isEmpty()) {
			throw new Exception("Notification Is not Available with user id : " + id);
		}
		
		List<NotificationResponseModal> notificationResponseModals = new ArrayList<>();
		
		for (Notification notification : notifications) {
			NotificationResponseModal notificationResponseModal = new NotificationResponseModal();
			
			notificationResponseModal.setId(notification.getId());
			notificationResponseModal.setUserId(notification.getUserId());
			notificationResponseModal.setTripDetailId(notification.getTripDetail().getId());
			notificationResponseModal.setTitle(notification.getTitle());
			notificationResponseModal.setMessage(notification.getMessage());
			notificationResponseModal.setCreatedAt(notification.getCreatedAt());
			
			notificationResponseModals.add(notificationResponseModal);
		}
		return notificationResponseModals;
	}

}
