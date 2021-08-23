$(function () {
    'use strict';

    Chart.defaults.global.defaultFontColor = '#75787c';

    var today = new Date();
    var date = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
    var time = today.getHours() + ":" + today.getMinutes();
    var dateTime = date + ' ' + time;
    document.getElementById('date-time').innerHTML = dateTime;
});