<?php
require "conn.php";
$email = $_GET["email"];
$pass = $_GET["pass"];
$username = $_GET["username"];
$firstname = $_GET["firstname"];
$lastname = $_GET["lastname"];
$mobile =$_GET["mobile"];
$city =$_GET["city"];
$address = $_GET["address"];



$sql = "SELECT * FROM users WHERE username = '$username' AND email = '$email'";
$result = mysqli_query($conn,$sql);
if(mysqli_num_rows($result) > 0){
  $status = "exist";
  
}
else{
$mysql_qry = "insert into users(email,pass,username,firstname,lastname,mobile,city,address)
values('$email','$pass','$username','$firstname','$lastname','$mobile','$city','$address')";
if(mysqli_query($conn,$mysql_qry)){
	$status = "ok";

	}
else{
	$status = "error";
	}	
}
mysqli_close($conn);
?>