

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Parkhaus Gruppe 11</title>


<script src='https://ccmjs.github.io/mkaul-components/parkhaus/versions/ccm.parkhaus-9.1.8.js'></script>


</head>
<body>
<ccm-parkhaus-9-1-8 server_url = "http://localhost:8080/Parkhaussimulation/Parkhaus"
					license_max = "30"
					client_categories = '["any","Familie","Frau", "Behinderte"]'
					extra_buttons =  '["UNDO", "Gesamteinnahmen","avg","Besucheranzahl", "min", "max"]'
					extra_charts = '["Einnahmen_pro_Kategorie", "Anteil_Besucher"]'
></ccm-parkhaus-9-1-8>
</body>

</html>
