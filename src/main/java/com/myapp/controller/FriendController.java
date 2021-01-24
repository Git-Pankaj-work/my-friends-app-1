package com.myapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp.entity.Friend;
import com.myapp.service.FriendService;

@Controller
public class FriendController {

	private static final Logger log = LoggerFactory.getLogger(FriendController.class);

	@Autowired
	FriendService friendService;

	
	//@RequestMapping("/")
	//@RequestMapping(value="/",method=RequestMethod.GET)
	@GetMapping("/")
	public String homePage() {
		log.info("Inside FriendController.homePage ");
		return "viewfriends";
	}

	// ################################################################
	// INSERT Friend Operation (way-01)
	// ################################################################

	//@RequestMapping("/add_new_friend_form_1")
	@GetMapping("/add_new_friend_form_1")
	public String showFormPage() {
		log.info("Inside FriendController.showFormPage ");
		log.info("added this line to test git");
		return "addFriendForm1";
	}

	//@RequestMapping("/save_my_friend_1")
	@GetMapping("/save_my_friend_1")
	public String saveMyFrind(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("phone") String phone, Model model) {

		log.info("Inside FriendController.saveMyFrind");

		Friend myfriend = new Friend();
		myfriend.setName(name);
		myfriend.setEmail(email);
		myfriend.setPhone(phone);

		log.debug("Input data:{}", myfriend);

		String res = friendService.addFriend(myfriend);
		log.info("Response  data: {}", res);

		model.addAttribute("msg", res);
		return "redirect:/view_all_friends";
	}

	// ################################################################
	// INSERT Friend Operation (way-02)
	// ################################################################

	@RequestMapping("/add_new_friend_form_2")
	public String showform2(Model m) {
		log.info("Inside FriendController.showform2 ");
		m.addAttribute("friend", new Friend());
		return "addFriendForm2";
	}

	//@RequestMapping(value = "/save_my_friend_2", method = RequestMethod.POST)
	@PostMapping(value = "/save_my_friend_2")
	public String saveMyFrind2(@Valid @ModelAttribute("friend") Friend friend, BindingResult bindingResult,	Model model) {
		log.info("Inside FriendController.saveMyFrind2 ");
		if (bindingResult.hasErrors()) {
			return "addFriendForm2";
		} else {
			String res = friendService.addFriend(friend);
			model.addAttribute("msg", res);
			return "redirect:/view_all_friends";
		}
	}

	// ################################################################
	// SELECT Operation
	// ################################################################

	@RequestMapping("/view_all_friends")
	public String viewFriends(Model m) {
		
		log.info("Inside FriendController.view_all_friends");

		List<Friend> list = friendService.getAllFriends();
		m.addAttribute("list", list);
		
		//log.debug();
		return "viewfriends";
	}

	// ################################################################
	// UPDATE Operation
	// ################################################################

	@RequestMapping(value = "/editfriend/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model m) {
		log.info("Inside FriendController.editfriend");
		Friend friend = friendService.getFriendById(id);
		m.addAttribute("friend", friend);
		return "friendeditform";
	}

	@RequestMapping(value = "/editfriend/editsave", method = RequestMethod.POST)
	public String editsave(@Valid  @ModelAttribute("friend")  Friend friend, BindingResult br) {
		log.info("Inside FriendController.editsave");
		if (br.hasErrors()) {
			return "friendeditform";
		}
		friendService.updateFriend(friend);
		return "redirect:/view_all_friends";
	}

	// ################################################################
	// DELETE Operation
	// ################################################################

	@RequestMapping(value = "/deletefriend/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		log.info("Inside FriendController.deletefriend");
		log.info("added this line to test git");
		friendService.deleteFriendById(id);
		return "redirect:/view_all_friends";
	}
}
