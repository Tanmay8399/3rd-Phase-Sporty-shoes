package com.sportyshoes.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sportyshoes.web.model.Cart;
import com.sportyshoes.web.model.OrderDetails;
import com.sportyshoes.web.model.Products;
import com.sportyshoes.web.model.Users;
import com.sportyshoes.web.service.CartService;
import com.sportyshoes.web.service.OrderDetailsService;
import com.sportyshoes.web.service.OrdersService;
import com.sportyshoes.web.service.ProductsService;
import com.sportyshoes.web.service.UsersService;


@Controller
public class ApplicationController {

	@Autowired
	private ProductsService productsService;
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@RequestMapping("/index")
	public ModelAndView getAllProducts() {
		List<Products> allProducts = productsService.getAllProducts();
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("products", allProducts);
		return modelAndView;
	}
	
	@RequestMapping("/adminlogin")
	public String getAdminLoginPage() {
		return "adminlogin";
	}

	@RequestMapping("/userlogin")
	public String getUserLoginPage() {
		return "userlogin";
	}

	@RequestMapping("signUpUser")
	public ModelAndView signUpUser(@ModelAttribute("user") Users user) {
		boolean isUserAdded = userService.addUser(user);
		List<Products> allProducts = productsService.getAllProducts();
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("products", allProducts);
		return modelAndView;
	}	

	
	@RequestMapping("/addNewUser")
	public String addUser(@ModelAttribute("user") Users user) {
		boolean isUserAdded = userService.addUser(user);
		return "adminpage";
	}	
	
	@RequestMapping("/validateUser")
	public ModelAndView validateUser(@RequestParam("username") String lid, @RequestParam("userpassword") String up) {
		if(lid.equals("admin")) {
			ModelAndView modelAndView = new ModelAndView("invaliduser");
			return modelAndView;
		} else {
			boolean result = userService.validateUser(lid,up);
			if(result) {
				List<Products> allProducts = productsService.getAllProducts();
				ModelAndView modelAndView = new ModelAndView("userpage");
				modelAndView.addObject("products", allProducts);
				modelAndView.addObject("username", lid);
				return modelAndView;
			}else {
				ModelAndView modelAndView = new ModelAndView("invaliduser");
				return modelAndView;
			}
		}
	}
		
	@RequestMapping("/validateAdmin")
	public String validateAdmin(@RequestParam("username") String lid, @RequestParam("userpassword") String up) {
		if(lid.equals("admin")) {
			boolean result = userService.validateUser(lid,up);
			if(result) {
				return "adminpage";
			}else {
				return "invalidadmin";
			}
		}else {
			return "invalidadmin";
		}
	}

	@RequestMapping("/adminpage")
	public String getAdminPage() {
		return "adminpage";
	}
	
	@RequestMapping("/listusers")
	public ModelAndView getUsersList() {
		List<Users> allUsers = userService.getAllUsers();
		ModelAndView MVallUsers = new ModelAndView("userlist");
		MVallUsers.addObject("Users",allUsers);
		return MVallUsers;
	}
	
	@RequestMapping("/edituser")
	public ModelAndView editUser(@RequestParam("lid") String lid) {
		Users euser = userService.getUser(lid);
		ModelAndView euMAV = new ModelAndView("edituser");
		euMAV.addObject("euser",euser);
		return euMAV;
	}

	@RequestMapping("/productslist")
	public ModelAndView getProductList() {
		List<Products> allProducts = productsService.getAllProducts();
		ModelAndView modelAndView = new ModelAndView("productslist");
		modelAndView.addObject("products", allProducts);
		return modelAndView;
	}		

	@RequestMapping("/editproduct")
	public ModelAndView editProduct(@RequestParam("pid") int pid) {
		Products eproduct = productsService.getProduct(pid);
		ModelAndView epMAV = new ModelAndView("editproduct");
		epMAV.addObject("eproduct",eproduct);
		return epMAV;
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(@RequestParam("uloginid") String uloginid, @RequestParam("upassword") String upassword, @RequestParam("uemail") String uemail, @RequestParam("uphone") String uphone) {
		boolean isUserUpdated = userService.updateUser(uloginid, upassword, uemail, uphone);
		return "adminpage";
	}
	
	@RequestMapping("/updateProduct")
	public String updateProduct(@RequestParam("uid") int id,@RequestParam("ubrandname") String brandname,@RequestParam("ugender") String gender, @RequestParam("usize") int size,@RequestParam("uprice") int price) {
		boolean isProductUpdated = productsService.updateProduct(id, brandname, gender, size, price);
		return "adminpage";
	}
	
	@RequestMapping("/adduser")
	public String addUserPage() {
		return "adduser";
	}

	@RequestMapping("/adduserbyadmin")
	public String addUserAdminPage() {
		return "adduserbyadmin";
	}

	
	@RequestMapping("/addproduct")
	public String getaddProductPage() {
		return "addproduct";
	}
	
	@RequestMapping("/addNewProduct")
	public String addProduct(@ModelAttribute("product") Products product) {
		boolean isProductAdded = productsService.addProduct(product); 
	return "adminpage";	
	}

	@RequestMapping("/addToCart")
	public ModelAndView addItemToCart(@RequestParam("pid") int pid, @RequestParam("lid") String lid, @RequestParam("pr") int pr, @RequestParam("bn") String bn, @RequestParam("gd") String gd, @RequestParam("sz") int sz) {
		boolean isItemAdded = cartService.addItemToCart(pid,lid,pr,bn,gd,sz);
		List<Products> allProducts = productsService.getAllProducts();
		ModelAndView modelAndView = new ModelAndView("userpage");
		modelAndView.addObject("products", allProducts);
		modelAndView.addObject("username", lid);
		return modelAndView;
	}
	
	@RequestMapping("/viewcart")
	public ModelAndView getUserCart(@RequestParam("lid") String lid) {
		List<Cart> userCart = cartService.getUserCartItems(lid);
		int carttotal = cartService.getUserCartTotal(lid);
		ModelAndView modelAndView = new ModelAndView("usercart");
		modelAndView.addObject("cart", userCart);
		modelAndView.addObject("username", lid);
		modelAndView.addObject("carttotal", carttotal);
		return modelAndView;
	}

	@RequestMapping("/userPage")
	public ModelAndView userPage(@RequestParam("username") String lid) {
		List<Products> allProducts = productsService.getAllProducts();
		ModelAndView modelAndView = new ModelAndView("userpage");
		modelAndView.addObject("products", allProducts);
		modelAndView.addObject("username", lid);
		return modelAndView;
	}
	
	@RequestMapping("/placeOrder")
	public ModelAndView placeOrder(@RequestParam("lid") String lid) {
		int orderid = ordersService.placeOrder(lid);
		int ordertotal = ordersService.getUserOrderTotal(orderid);
		List<OrderDetails> userOrderDetails = orderDetailsService.getUserOrderDetails(orderid);
		ModelAndView modelAndView = new ModelAndView("userorderpage");
		modelAndView.addObject("orderdetail", userOrderDetails);
		modelAndView.addObject("username", lid);
		modelAndView.addObject("orderid", orderid);
		modelAndView.addObject("ordertotal",ordertotal);
		return modelAndView;
	}
	
	@RequestMapping("/reportparam")
	public String getReportParam() {
		return "rparam";
	}

	@RequestMapping("/callReport")
	public ModelAndView getCallReport(@RequestParam("rbrand") String rbrand,@RequestParam("rdate") String rdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<OrderDetails> purchasedetails;
		ModelAndView mAVpurchase = new ModelAndView("purchasereport");
		try {
			purchasedetails = orderDetailsService.getPurchaseReport(rbrand, sdf.parse(rdate));
			mAVpurchase.addObject("purchasedetails", purchasedetails);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mAVpurchase;
	}
}
