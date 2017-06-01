<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Event</title>
</head>
<body>

	<form method="post" action="NewEventServlet">
		<div style="padding: 10px 0 0 50px;">
			<div id="event-box">
				<H2>New Event</H2>
				<br />
				<!-----------Event Name ------------>
				<div id="event-name" style="margin-top: 20px;">Event Name:</div>
				<div id="event-name-box" style="margin-top: 20px;">
					<input name="eventName" title="event-name" value="" size="30"
						maxlength="50" />
				</div>
				<br />
				<!-----------Event Type ------------->
				<div id="">Event Type:</div>
				<div id="event-type-field">
					<input name="event-type" type="text" title="event-type" value=""
						size="30" maxlength="48" />
				</div>
				<br />
				<!-----------Event Date ------------->
				<div>
					Start date: <input type="date" name="start-date">
				</div>
				<br />
				<div>
					End date: <input type="date" name="end-date">
				</div>
				<br />
				<!-----------Venue ------------>
				<!-- Retrieve all venues from database and display them in a dropdown box -->
				<!-- Assume I have the venue list from calling a java method  -->
				<div>
					Event location: <select>
						<c:forEach items="${venueList}" var="venue">
							<option value="${venue.id}"><c:out
									value="${venue.name}" /></option>
						</c:forEach>
					</select>
				</div>
				<!--Event Description -->
				<div id="event-name" style="margin-top: 20px;">Event
					Description:</div>
			</div>
			<textarea style="width: 700px; height: 80px;"></textarea>
			<!-- -->
			<br /> <br /> <br /> <input style="margin-left: 100px;"
				type="submit" value="Submit" />
		</div>

		</div>

	</form>
</body>
</html>