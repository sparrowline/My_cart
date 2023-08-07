/**
 * 
 */
function add_to_cart(pid, pname, price) {
	let cart = localStorage.getItem("cart");
	if (cart == null) {
		//no cart yet 
		let products = [];
		let product = { productId: pid, productName: pname, productQuantity: 1, productPrice: price }
		products.push(product);
		localStorage.setItem("cart", JSON.stringify(products));
		console.log("product is added for the first time")
		

	} else {
		//cart is already present
		let pcart = JSON.parse(cart);


		let oldProduct = pcart.find((item) => item.productId == pid)
		console.log(oldProduct)
		if (oldProduct) {
			//we have to increase the quantity
			oldProduct.productQuantity = oldProduct.productQuantity + 1
			pcart.map((item)=>{
				
				if(item.productId==oldProduct.productId)
				{
					item.productaQuantity=oldProduct.productQuantity;
					
				}
			})
			localStorage.setItem("cart", JSON.stringify(pcart));
			console.log("product Quantity is increased")
			showToast (oldProduct. productName + " quantity is increased , Quantity = "+oldProduct.productQuantity)
		} else {
			//we have to add the quantity

			let product = { productId: pid, productName: pname, productQuantity: 1, productPrice: price }
			pcart.push(product)
			localStorage.setItem("cart", JSON.stringify(pcart));
			console.log("product is added")
			showToast ("Product is added to cart")
		}
	}
	updateCart();
} 

//Update Cart:


function updateCart(){
	let CartString=localStorage.getItem("cart"); //from local storage fetching the data which will be in the form of JSON string
	
	let cart = JSON.parse(CartString); //parsing String data in javascript object
	if(cart ==null || cart.length ==0){
		console.log("cart is empty")
		$(".cart-items").html("( 0 )");
		$(".cart-body").html("<h3> Cart does not have any items <h3>");
		$(".checkout-btn").addClass('disabled');
	}else{
		//There is somthing in cart to show
		console.log(cart)
				$(".cart-items").html(`(${cart.length})`);
				
				let table= `
				<table class='table'>
				<thead class='thead-light'>
					<tr>
					<th>Item Name</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Total price</th>
					<th>Action</th>
					
					</tr>
				
				
				
				
				</thead>
				
				
				`;
				
				let totalPrice=0;
			cart.map((item)=> {
				
				table+=`
				<tr>
					<td>${item.productName}</td>
					<td>${item.productPrice}</td>
					<td>${item.productQuantity}</td>
					<td>${item.productQuantity*item.productPrice}</td>
					<td><button onclick='deletItemFromCart(${item.productId})' class='btn btn-danger btn-sm'>Remove</td>
				</tr>
				
				
				`
				totalPrice += item.productPrice * item.productQuantity;
				console.log(totalPrice);
			})

		table=table+`
		<tr><td colspan='5' class='text-right font-weight-bold m-5'> Total Price : ${totalPrice}</td></tr>
		
		</table>`
		
		
	    $(".cart-body").html(table)

		
		
	}
}

//delete item
function deletItemFromCart(pid)
{
	let cart = JSON.parse(localStorage.getItem('cart'));
	let newcart = cart.filter((item)=>item.productId !=pid)
	
	localStorage.setItem('cart',JSON.stringify(newcart))
	
	updateCart();
	showToast ("Item is removed from cart ")
}


 $(document).ready(function(){
	 updateCart()
 })


	
	

function showToast(content) {
    $("#toast").addClass("display");
    $("#toast").html(content);
    setTimeout(() => {
        $("#toast").removeClass("display");
    }, 2000);
    }
 