function getXMLHttpRequest(){
	if(window.ActiveXObject){
		try{
			return new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e1){
			try{
				return new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e2){
				return null;
			}
		}
	}else if(window.XMLHttpRequest){
		return new XMLHttpRequest();
	}else{
		return null;
	}
}

var httpRequest = null;
// url 전송할 대상 ,params 전송할 값 ,callback 리턴핸들링값 ,method get or post 
function sendRequest(url, params, callback, method){	// 괄호안에 4가지 옵션 어디 메소드 (get or post) : 핸들링 값 지정  
	httpRequest = getXMLHttpRequest();//1번new XMLHttpRequest(); 객체 생성 = 비동기 통신을 xml 로 연동하겠다 (ajax시작) 페이지마다 쓰는게 아니라 여기서 js하나만 심으면됨 

	// jsp  - 개발자 // method 지정 
	var httpMethod = method ? method : 'GET'; //없으면 get 있으면 post 
	if(httpMethod != 'GET' && httpMethod != 'POST'){
		httpMethod = 'GET';
	}
	//param에 대한 조건 지정 
	var httpParams = (params == null || params == '') ? null : params; //null대입 (문자열로) 
	var httpUrl = url; //url 받아서
	if(httpMethod == 'GET' && httpParams != null){  //계산 만일 get 방식이고 param값이 null이 아닐경우에 
		httpUrl = httpUrl + "?" + httpParams;   //url+쿼리스트링을 만든다 
	}
	
	//alert("method == " + httpMethod + "\turl == " + httpUrl + "\tparam == " + httpParams);
	httpRequest.open(httpMethod, httpUrl, true);  //2번  open method 
	httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	httpRequest.onreadystatechange = callback; //핸들러값 매핑 
	//alert(httpMethod == 'POST' ? httpParams : null);
	httpRequest.send(httpMethod == 'POST' ? httpParams : null);
}
//총 4파트 