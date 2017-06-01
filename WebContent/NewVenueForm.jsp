<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="NewVenueServlet">
		<div style="padding: 10px 0 0 50px;">
			<div id="venue-box">
				<H2>Enter Venue Information</H2>
				<br />
				<!--Venue Name -->
				<div id="venue-name" style="margin-top: 20px;">Venue Name:</div>
				<div id="venue-name-box" style="margin-top: 20px;">
					<input name="venueName" title="venue-name" value="" size="30"
						maxlength="50" />
				</div>
				<br />
				<!--Venue Address -->
				<div id="">Location:</div>
				Street Address <br /> <input name="street-address" type="text"
					size="30" maxlength="48" /><br /> City <br /> <input name="city"
					type="text" size="30" maxlength="48" /><br /> State <br /> <input
					name="state" type="text" size="30" maxlength="48" /><br /> Zip
				code <br /> <input name="zipcode" type="text" size="30"
					maxlength="48" />
			</div>
			<br />
			<!--Submit button -->
			<br /> <br /> <br /> <input style="margin-left: 100px;"
				type="submit" value="Submit" />
		</div>

		</div>

	</form>
</body>
</html>