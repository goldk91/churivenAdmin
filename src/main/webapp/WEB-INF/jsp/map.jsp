<%--
  Created by IntelliJ IDEA.
  User: cubic
  Date: 2021-12-30
  Time: 오전 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script>

        var lat;
        var lng;

        function gpsEvent(lat, lng){
            console.log('gpsEvent');
            console.log(lat + ', ' + lng );
        }

        function reload(){
            $.ajax({
                url: "/gps",
                type: "POST",
                dataType: "json",
                data: { stf_seq: '1', cmp_seq: '1' },
                success: function(data){

                    console.log(data.json);
                    /*lat = data.lat;
                    lng = data.lng;

                    console.log("lat: " + lat + ", lng: " + lng);*/

                    //panTo();

                      /*var html =
                        '<div class="gpsList" style="border:1px dashed blue; width:100%; height:100px;" onclick="gpsEvent('+lat+', '+lng+')">' +
                        '</div>';
                    $('#gpsListBox').append(html);*/
                }
            });


        }
    </script>
</head>
<body style="margin:0px;">
<!-- 지도를 표시할 div 입니다 -->
<div id="map" style="width:80%;height:900px; float:left; position:relative">
    <button onclick="reload()" style="position:absolute; z-index: 10">새로고침</button>
</div>

<div id="gpsListBox" style="width:20%; height:900px; background-color:red; float:right;" >

</div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0ae56d53743192f405adf83ef570873d"></script>
<script>
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };

    // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
    var map = new kakao.maps.Map(mapContainer, mapOption);

    function panTo(){
        var LatLon = new kakao.maps.LatLng(lat, lng);
        // 마커를 생성합니다
        var marker = new kakao.maps.Marker({
            position: LatLon
        });

        marker.setMap(map);
        map.panTo(LatLon);
    }

</script>
</body>
</html>