var control = "";   //모든페이지의 스크립트를 호출할떄 사용 
//bcode=9&pg=1&key=&word=    : function listArticle()를 호출 
function moveWrite(bcode) {  //code받아서 
	document.getElementById("bcode").value = bcode;
	document.getElementById("pg").value = "1";
	document.getElementById("key").value = "";
	document.getElementById("word").value = "";
	
	document.getElementById("commonForm").action = root + control + "/write.playdata";   //쓰는 곳으로 가
	document.getElementById("commonForm").submit();
}

function listArticle(bcode, pg, key, word) {   //url이 4개만 받으면 호출 해서 
	document.getElementById("bcode").value = bcode;
	document.getElementById("pg").value = pg;
	document.getElementById("key").value = key;
	document.getElementById("word").value = word;
	
	document.getElementById("commonForm").action = root + control + "/list.playdata";
	document.getElementById("commonForm").submit();  //여기서 submit 
	///commonForm앞의 페이지에서 값을 받아서 
//	commonForm에 있는 모든 데이타를 action의 url로 값을 전송한다. 
}

function viewArticle(bcode, pg, key, word, seq) {
	document.getElementById("bcode").value = bcode;
	document.getElementById("pg").value = pg;
	document.getElementById("key").value = key;
	document.getElementById("word").value = word;
	document.getElementById("seq").value = seq;
	
	document.getElementById("commonForm").action = root + control + "/view.playdata";
	document.getElementById("commonForm").submit();
}