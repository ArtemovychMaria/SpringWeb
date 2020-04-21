$("#photo-file").change(function (){
    var fd = new FormData();
    var file = $('#photo-file')[0].files[0];

    if(file === undefined){
        return;
    }

    fd.append('photoFile', file);
    $.ajax({
        url: '/Game/student-photo-files/upload',
        type: 'post',
        data: fd,
        contentType: false,
        processData: false,
        success: function (photoId) {
            $("#student-photo")
                .attr("src", "/Game/student-photo-files/download/" + photoId);
            $("#photo-id").val(photoId)
        },
    });
});