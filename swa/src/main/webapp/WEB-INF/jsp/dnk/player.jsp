<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Player</title>
<meta name="decription" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link rel="stylesheet" href="resources/css/player.css" />
<link rel="stylesheet" href="resources/tui-grid/tui-grid.css" />
</head>

<body>
	 <!-- <audio
      id="audio"
      preload="metadata"
      controls
      controlsList="nodownload"
      style="width: 100%"
    ></audio>  -->
	<audio id="audio" preload="metadata"></audio>
	<div class="audio-wrap">
		<img id="btn_play" src="resources/image/baseline_play_arrow_black_18dp.png"
			width="28" height="28" style="margin: 10px;"></a> <span
			id="audiocur" class="audio-timeNow">0:00</span> <span id="audiomax"
			class="audio-timeAll">0:00</span>
		<div class="flc-vr" style="margin-left: 20px; margin-right: 10px;">
			<a id="btn_half" style="font-size: 12px; cursor: pointer;">.5x</a> <a
				id="btn_double" style="font-size: 12px; cursor: pointer;">2x</a>
		</div>
		<input id="progress" class="audio-progressbar" type="range" min="0"
			max="100" step="1" />
		<div class="audio-volume">
			<input class="audio-volumebar" type="range" /> <img
				src="resources/image/baseline_volume_up_black_18dp.png" width="28"
				height="28" />
		</div>
	</div>

	<div id="grid" style="margin-top: 20px"></div>
	<script src="resources/js/player.js"></script>
	<script src="resources/tui-grid/tui-grid.js"></script>
</body>
</html>