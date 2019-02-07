<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>시작하기</title>

	<style type="text/css">
		.ml4 {
			position: relative;
			font-weight: 900;
			font-size: 4.5em;
		}

		.ml4 .letters {
			position: absolute;
			margin: auto;
			left: 0;
			top: 0.3em;
			right: 0;
			opacity: 0;
			color: white;
		}
	</style>
</head>

<body style="background-image: url('resources/images/night.jpg'); background-size: cover;">
	<div align="center">		
		<br> <br> <br> <br> <br> <br>
			<h1 class="ml4">
			<span class="letters letters-1">MyBatis / Spring </span>
			<span class="letters letters-2">DB : Oracle 11g XE</span>
			<span class="letters letters-3">Go!</span>
		</h1>
		<script type="text/javascript" src="resources/js/jquery-3.1.1.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/2.0.2/anime.min.js"></script>
		<script type="text/javascript">
			var ml4 = {};
			ml4.opacityIn = [0, 1];
			ml4.scaleIn = [0.4, 1];
			ml4.scaleOut = 2;
			ml4.durationIn = 400;
			ml4.durationOut = 300;
			ml4.delay = 250;

			anime.timeline({
					loop: false
				})
				.add({
					targets: '.ml4 .letters-1',
					opacity: ml4.opacityIn,
					scale: ml4.scaleIn,
					duration: ml4.durationIn
				}).add({
					targets: '.ml4 .letters-1',
					opacity: 0,
					scale: ml4.scaleOut,
					duration: ml4.durationOut,
					easing: "easeInExpo",
					delay: ml4.delay
				}).add({
					targets: '.ml4 .letters-2',
					opacity: ml4.opacityIn,
					scale: ml4.scaleIn,
					duration: ml4.durationIn
				}).add({
					targets: '.ml4 .letters-2',
					opacity: 0,
					scale: ml4.scaleOut,
					duration: ml4.durationOut,
					easing: "easeInExpo",
					delay: ml4.delay
				}).add({
					targets: '.ml4 .letters-3',
					opacity: ml4.opacityIn,
					scale: ml4.scaleIn,
					duration: ml4.durationIn
				}).add({
					targets: '.ml4 .letters-3',
					opacity: 0,
					scale: ml4.scaleOut,
					duration: ml4.durationOut,
					easing: "easeInExpo",
					delay: ml4.delay
				}).add({
					targets: '.ml4',
					opacity: 0,
					duration: 300,
					delay: 300
				});
			setTimeout("location.href='home.do' ", 3000);
		</script>
	</div>
</body>

</html>