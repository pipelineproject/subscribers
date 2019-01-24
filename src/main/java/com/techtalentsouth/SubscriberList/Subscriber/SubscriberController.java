package com.techtalentsouth.SubscriberList.Subscriber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SubscriberController {
	
	@Autowired
	private SubscriberRepository subscriberRepository;
	
	@GetMapping("/")
	public String index(Subscriber subscriber) {
		return "subscriber/index.html";
	}
		
	@PostMapping(value="/result")
	public String addNewSubscriber(Subscriber subscriber, Model model) {
		subscriberRepository.save(subscriber);
//		subscriberRepository.save(new Subscriber(subscriber.getFirstName(), subscriber.getLastName(), subscriber.getEmail(), subscriber.getUserName(), subscriber.getPassword(), subscriber.getDateOfBirth(), subscriber.getDateCreated()));
		model.addAttribute("firstName", subscriber.getFirstName());
		model.addAttribute("lastName", subscriber.getLastName());
		model.addAttribute("email", subscriber.getEmail());
		model.addAttribute("userName", subscriber.getUserName());
		model.addAttribute("password", "it's a secret");
		model.addAttribute("dateOfBirth", subscriber.getDateOfBirth());
		model.addAttribute("dateCreated", subscriber.getDateCreated());
		//model.addAttribute("information", subscriber.toString());
		return "subscriber/result";
	}
}
