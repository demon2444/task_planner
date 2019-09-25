$(function () {

    let time = new Date();
    let timeForm = time.getHours() + ":" + time.getMinutes() + ":" + time.getSeconds();
    //console.log(time);

    function showTime() {
        setInterval(timeForm, 1000)

    }


    let show = $('#show')
    show.on('click', function () {
      //timeForm
        return showTime()
        //showTime()
    })


})