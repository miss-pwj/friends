
window.onload = function(){
    var oWrap = document.getElementById("wrap");
    var oImg = oWrap.getElementsByTagName("img");
    var oImgLength = oImg.length;
    var Deg = 360/oImgLength;//获取度数
    var nowX,nowY,lastX,lastY,minusX,minusY;
    var roY = 0,roX = -10;
    var timer = null;
    for(var i=0;i<oImgLength;i++){
        oImg[i].style.transform = "rotateY("+i*Deg+"deg) translateZ(300px)";  //向元素应用 2D 或 3D 转换
        oImg[i].style.transition = "transform 1s "+(oImgLength-1-i)*0.2+"s";  //设置元素过渡效果
    };
    document.onmousedown = function(e){
        var ev = e||window.event;
        lastX = ev.clientX;      //定义鼠标的位置
        lastY = ev.clientY;
        window.onresize=mTop;   //窗口大小改变时调用
        function mTop(){
            var wH=window.innerHeight;
        }
        //鼠标移动
        this.onmousemove = function(e){
            var ev = e||window.event;
            
            clearInterval(timer);

            //拿到当前坐标的值
            nowX = ev.clientX;
            nowY = ev.clientY;
            
            //获取差值
            minusX = nowX - lastX;
            minusY = nowY - lastY;
            
            roY += minusX*0.2;
            roX -= minusY*0.2;
            oWrap.style.transform = "rotateX("+roX+"deg) rotateY("+roY+"deg)";
            
            lastX = nowX;
            lastY = nowY;

        };
        
        this.onmouseup = function(){
            this.onmousemove = null;
            timer = setInterval(function(){
                minusX *= 0.95;//让距离越来越小，乘以摩擦系数
                minusY *= 0.95;
                roY += minusX*0.2;
                roX -= minusY*0.2;
                oWrap.style.transform = "rotateX("+roX+"deg) rotateY("+roY+"deg)";
                if(Math.abs(minusX)<0.5 && Math.abs(minusY)<0.5){
                    clearInterval(timer);
                }
            },13);

        };
        return false;
    };
}