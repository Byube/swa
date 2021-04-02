<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Accordion - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#accordion" ).accordion();
  } );
  </script>
  <meta name="decription" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link rel="stylesheet" href="resources/css/player.css" />
<link rel="stylesheet" href="resources/tui-grid/tui-grid.css" />
</head>
<body>
 
<div id="accordion">
  <h3>Section 1</h3>
  <div>
    <p>
    <audio id="audio" preload="metadata"></audio>
    <div class="audio-wrap">
      <img id="btn_play" src="resources/image/baseline_play_arrow_black_18dp.png" width="28" height="28" style="margin: 10px;"></a>
      <span id="audiocur" class="audio-timeNow">0:00</span>
      <span id="audiomax" class="audio-timeAll">0:00</span>
      <div class="flc-vr" style="margin-left: 20px; margin-right: 10px;">
        <a id="btn_half" style="font-size: 12px; cursor: pointer;">.5x</a>
        <a id="btn_double" style="font-size: 12px; cursor: pointer;">2x</a>
      </div>
      <input id="progress" class="audio-progressbar" type="range" min="0" max="100" step="1" />
      <div class="audio-volume">
        <input class="audio-volumebar" type="range" />
        <img src="resources/image/baseline_volume_up_black_18dp.png" width="28" height="28" />
      </div>
    </div>

    <div id="grid" style="margin-top: 20px"></div>
    <script src="resources/js/player.js"></script>
    <script src="resources/tui-grid/tui-grid.js"></script>
    </p>
  </div>
  <h3>Section 2</h3>
  <div>
    <p>
    Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet
    purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor
    velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In
    suscipit faucibus urna.
    </p>
  </div>
  <h3>Section 3</h3>
  <div>
    <p>
    Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis.
    Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero
    ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis
    lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.
    </p>
    <ul>
      <li>List item one</li>
      <li>List item two</li>
      <li>List item three</li>
    </ul>
  </div>
  <h3>Section 4</h3>
  <div>
    <p>
    Cras dictum. Pellentesque habitant morbi tristique senectus et netus
    et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in
    faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia
    mauris vel est.
    </p>
    <p>
    Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus.
    Class aptent taciti sociosqu ad litora torquent per conubia nostra, per
    inceptos himenaeos.
    </p>
  </div>
</div>
 
 
</body>
</html>