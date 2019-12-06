<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<c:set var="pageTitle" value="${park.parkname}" />

<%@include file="common/detailheader.jspf"%>
<link rel="stylesheet" type="text/css" href="css/style.css" />

<div class="d-flex bd-highlight">
	<div class="p-2 flex-fill bd-highlight"></div>
	<div class="p-2 flex-fill bd-highlight">
		<a class="park-image"
			href=href="<c:url value="/detailPage?parkcode=${park.parkcode }" />">
			<img
			src="<c:url value="img/parks/${ park.parkcode.toLowerCase() }.jpg" />" />
		</a>
	</div>
	<div class="p-2 flex-fill bd-highlight">
		<p class="text center">
		<h2>${park.parkname}</h2> 

	
		${park.parkDescription};
		
		<br> <br> <br> <br> <br> <br> <br>
		<p class="text-center">
		<i>"${park.inspoQuote}"</i>
		</p>
	</div>
</div>

<div class="d-flex bd-highlight">
	<div class="p-2 flex-fill bd-highlight"></div>
	<div class="p-2 flex-fill bd-highlight">
		<table class="table table-hover">
			<tbody>
				<tr>
					<th scope="row">Park Code</th>
					<td>${park.parkcode }</td>
				</tr>
				<tr>
					<th scope="row">Park Name</th>
					<td>${park.parkname }</td>
				</tr>
				<tr>
					<th scope="row">State</th>
					<td>${park.state }</td>
				</tr>
				<tr>
					<th scope="row">Acreage</th>
					<td>${park.acreage } acres</td>
				</tr>
				<tr>
					<th scope="row">Elevation In Feet</th>
					<td>${park.elevationInFeet} feet</td>
				</tr>
				<tr>
					<th scope="row">Miles Of Trail</th>
					<td>${park.elevationInFeet} miles</td>
				</tr>
				<tr>
					<th scope="row">Numbers Of Campsites</th>
					<td>${park.numberOfCampsites} campsites</td>
				</tr>
				<tr>
					<th scope="row">Climate</th>
					<td>${park.climate}</td>
				</tr>
				<tr>
					<th scope="row">Annual Visitor Count</th>
					<td>${park.annualVisitorCount} visitors per year</td>
				</tr>
				<tr>
					<th scope="row">Entry Fee</th>
					<td><fmt:setLocale value="en_US" /> <fmt:formatNumber
							value="${park.entryFee}" type="currency" /></td>
				</tr>
				<tr>
					<th scope="row">Animal Species</th>
					<td>${park.numberOfAnimalSpecies} species</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="p-2 flex-fill bd-highlight"></div>
</div>

<div id="tempChange">
	<c:url var="formAction" value="/detailPage" />
	<form method="POST" action="${formAction }">
		<div class="btn-f">
			<input type="hidden" name="tempType" value="F" /> <input
				type="hidden" name="parkcode" value="${park.parkcode }" /> <input
				type="submit" name="false" value="Fahrenheit" />
		</div>
	</form>
	<form method="POST" action="${formAction }">
		<div class="btn-c">
			<input type="hidden" name="tempType" value="C" /> <input
				type="hidden" name="parkcode" value="${park.parkcode }" /> <input
				type="submit" name="true" value="Celcius" />
		</div>
	</form>
</div>



<div class="container">
	<div class="d-flex flex-row">
			<c:forEach var="weather" items="${weathers}">
				<div class="p-2">
					<c:choose>
						<c:when test="${weather.foreCastValue == 1 }">
							<h1>Today</h1>
						</c:when>
						<c:when test="${weather.foreCastValue == 2 }">
							<h1>Tomorrow</h1>
						</c:when>
						<c:when test="${weather.foreCastValue == 3 }">
							<h1>
								<c:set var="tomorrow"
									value="<%=new Date(new Date().getTime() + 60 * 60 * 24 * 2000)%>" />
								<fmt:formatDate type="date" value="${tomorrow}" pattern="E" />
							</h1>
						</c:when>
						<c:when test="${weather.foreCastValue == 4 }">
							<h1>
								<c:set var="tomorrow"
									value="<%=new Date(new Date().getTime() + 60 * 60 * 24 * 3000)%>" />
								<fmt:formatDate type="date" value="${tomorrow}" pattern="E" />
							</h1>
						</c:when>
						<c:when test="${weather.foreCastValue == 5 }">
							<h1>
								<c:set var="tomorrow"
									value="<%=new Date(new Date().getTime() + 60 * 60 * 24 * 4000)%>" />
								<fmt:formatDate type="date" value="${tomorrow}" pattern="E" />
							</h1>
						</c:when>
					</c:choose>
				


				<!--  make celcius or fahrenheit choice -->
				<br>
				<c:url var="weatherImgUrl" value="img/weather/" />
				<c:choose>
					<c:when test="${weather.foreCast.contains('partly') }">
						<img src="${weatherImgUrl}partlyCloudy.png" />
					</c:when>
					<c:otherwise>
						<img src="${weatherImgUrl}${weather.foreCast}.png" />
						<br>
					</c:otherwise>
				</c:choose>

				<p class="highOrLow">
					High:
					<c:choose>
						<c:when test="${celcius}">
							<fmt:formatNumber maxFractionDigits="0">
								<c:out value="${(weather.high - 32) * 5 / 9}" />
							</fmt:formatNumber>&deg;C
						</c:when>
						<c:otherwise>
							<c:out value="${weather.high}" />&deg;F
						</c:otherwise>
					</c:choose>
					Low:
					<c:choose>
						<c:when test="${celcius}">
							<fmt:formatNumber maxFractionDigits="0">
								<c:out value="${(weather.low - 32) * 5 / 9}" />
							</fmt:formatNumber>&deg;C
						</c:when>
						<c:otherwise>
							<c:out value="${weather.low}" />&deg;F
						</c:otherwise>

					</c:choose>
					<br>
					<c:if test="${weather.high >= 75}">
						<i>Bring an extra gallon of water!</i>
					</c:if>
					<c:if test="${weather.high - weather.low >= 20}">
						<i>Wear breathable layers!</i>
					</c:if>
					<c:if test="${weather.low <= 20}">
						<i>Make sure to wear lots of layers! It's going to be very
							cold.</i>
					</c:if>
					<br>
					</p>
					</div>
			</c:forEach>
		</div>
</div>








<%@include file="common/footer.jspf"%>