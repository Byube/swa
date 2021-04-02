let audio;
let audioProgressbar;

let btnPlay;
let btnHalf;
let btnDouble;

let audioTimeAll;
let audioTimeNow;

let duration;
// let last_position = 0;
let onplayhead = false;
let isPlaying = false;

let grid;
const griddata = [];

window.onload = function (event) {
  initGrid();

  getText();
  // loadData();

  initAudio();
};

function initAudio() {
  console.log('initAudio()');

  audioTimeAll = document.getElementById('audiomax');
  audioTimeNow = document.getElementById('audiocur');

  //
  audio = document.getElementById('audio');
  // audio = new Audio();
  // audio.preload = 'metadata';

  console.log(audio);

   audio.src = 'http://98.28.8.45:28881/listen?url=/var/REC/RecSee_Data/20190902/08/20190902_082936_0324_user_4692_01082322114_4692_386971_0008.mp3';
  // audio.src = 'http://localhost:9220/player/getwav/';
  // audio.src = 'http://localhost:9230/player/getstream/';
  audio.src = 'http://localhost:8880/getstream/';

  audio.addEventListener('timeupdate', timeUpdate, false);
  audio.addEventListener(
    'loadedmetadata',
    function () {
      duration = audio.duration;
      console.log(duration);
      audioTimeAll.innerHTML = fancyTimeFormat(duration);
    },
    false
  );
  audio.onloadedmetadata = function () {
    duration = audio.duration;
    console.log(duration);
    audioTimeAll.innerHTML = fancyTimeFormat(duration);
  };

  audioProgressbar = document.getElementById('progress');
  audioProgressbar.value = 0;
  audioProgressbar.addEventListener('change', function () {
    console.log('change()');
    console.log(audioProgressbar.value);
    console.log(audio.currentTime);
    audio.currentTime = (audioProgressbar.value / 100) * duration;
  });
  audioProgressbar.addEventListener('mousedown', function (e) {
    console.log('mousedown()');
    audio.pause();
    onplayhead = true;
  });
  audioProgressbar.addEventListener('mouseup', function (e) {
    console.log('mouseup()');

    setTimeout(function () {
      onplayhead = false;
      console.log(audio.currentTime);
      audio.play();
    }, 1000);
  });

  //
  btnPlay = document.getElementById('btn_play');
  btnPlay.addEventListener('click', function () {
    console.log('btn_play click()');

    if (!isPlaying) {
      playAudio();
      pauseAudio();
      playAudio();
      btnPlay.src = 'resources/image/baseline_pause_black_18dp.png';
    } else {
      pauseAudio();
      btnPlay.src = 'resources/image/baseline_play_arrow_black_18dp.png';
    }
  });

  btnHalf = document.getElementById('btn_half');
  btnHalf.addEventListener('click', function () {
    console.log('btn_half click()');

    if (isPlaying) {
      audio.playbackRate = 0.5;
    }
  });

  btnDouble = document.getElementById('btn_double');
  btnDouble.addEventListener('click', function () {
    console.log('btn_double click()');
    if (isPlaying) {
      audio.playbackRate = 2.0;
    }
  });
}

function timeUpdate() {
  // console.log('timeUpdate()');
  if (!onplayhead) {
    const playPercent = 100 * (audio.currentTime / duration);
    audioProgressbar.value = playPercent;
    audioTimeNow.innerHTML = fancyTimeFormat(audio.currentTime);
    console.log(audio.currentTime);

    griddata.forEach(function (elem) {
      if (audio.currentTime * 100 > elem.start && audio.currentTime * 100 < elem.end) {
        // console.log(elem.rowKey);
        grid.focusAt(elem.rowKey, 2, true);
      }
    });
  }
}

function playAudio() {
  audio.play();
  isPlaying = true;
}

function pauseAudio() {
  audio.pause();
  isPlaying = false;
}

function initGrid() {
  console.log('initGrid()');

  grid = new tui.Grid({
    el: document.getElementById('grid'),
    // scrollX: false,
    // scrollY: false,
    scrollX: false,
    scrollY: true,
    bodyHeight: 600,
    // selectionUnit: 'row',
    usageStatistics: false,
    columns: [
      {
        header: 'start',
        name: 'start',
        align: 'center',
        width: 70,
      },
      {
        header: 'end',
        name: 'end',
        align: 'center',
        width: 70,
      },
      {
        header: 'utterence',
        name: 'utt',
      },
    ],
  });

  grid.on('mousedown', function (ev) {
    // console.log(ev);
    onplayhead = true;
  });

  grid.on('click', function (ev) {
    // console.log(ev);
    onplayhead = false;

    const idx = ev.rowKey;
    console.log(griddata[idx].start);
    audio.currentTime = griddata[idx].start / 100;
    console.log(audio.currentTime);
  });

  tui.Grid.applyTheme('clean');
}

function loadData(sttresult) {
  console.log('loadData()');

  // console.log(sttresult);

  // const lines = sttresult.toString().split(/\r\n|\n/);
  const lines = sttresult.split('\n');
  // console.log(lines);

  griddata.length = 0;

  lines.forEach(function (elem) {
    const splited = elem.split('|');
    if (splited.length >= 3) {
      const utt = {
        // speaker: Number(splited[0]),
        start: Number(splited[0]),
        end: Number(splited[1]),
        utt: splited.splice(2).join(' '),
      };
      // console.log(utt);
      griddata.push(utt);
    }
  });

  // console.log(griddata);
  grid.resetData(griddata);
}

// https://stackoverflow.com/a/11486026
function fancyTimeFormat(duration) {
  // Hours, minutes and seconds
  var hrs = ~~(duration / 3600);
  var mins = ~~((duration % 3600) / 60);
  var secs = ~~duration % 60;

  // Output like "1:01" or "4:03:59" or "123:03:59"
  var ret = '';

  if (hrs > 0) {
    ret += '' + hrs + ':' + (mins < 10 ? '0' : '');
  }

  ret += '' + mins + ':' + (secs < 10 ? '0' : '');
  ret += '' + secs;
  return ret;
}

function getText() {
  httpRequest = new XMLHttpRequest();

  if (!httpRequest) {
    alert('Giving up :( Cannot create an XMLHTTP instance');
    return false;
  }
  httpRequest.onreadystatechange = function () {
    if (httpRequest.readyState === XMLHttpRequest.DONE) {
      if (httpRequest.status === 200) {
        // console.log(httpRequest.responseText);
        const res = httpRequest.responseText;
        loadData(res);
      } else {
        alert('There was a problem with the request.');
      }
    }
  };

  httpRequest.open('GET', 'http://localhost:8880/gettxt/');
  httpRequest.send();
}
