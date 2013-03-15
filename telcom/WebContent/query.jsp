<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>短信查询</title>
<link href="css/index_query.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/dateUtil.js"></script>

<script type="text/javascript">

$(function(){
	
	$("#queryBtn").click(function(){
		
		var startTime = $("#startTime").val();
		var endTime = $("#endTime").val();
		var telphone = $("#telphone").val();
		
		$.ajax({
			type:"get",
			dataType:"json",
			url:"query.do?startTime="+startTime+"&endTime="+endTime+"&telphone="+telphone+"&pagerNo=1&mtpagerNo=1&bupagerNo=1",
			complete:function(){$("#trlist").hide();$("#mttrlist").hide();$("#putrlist").hide();},
			cache:false,
			success:function(msg)
			{
				if(msg.paList!=null)
				{
					$("#trlist").show();
					$(".ready_all").remove();
					//上行
					var modata =msg.paList[0];
					if(modata!="")
					{
						var molist = modata.list;
						$.each(molist,function(i,n){
							var row = $("#trlist").clone();
							row.find("#t1").text(n.smsServiceActivationNumber);
							row.find("#t2").text(n.senderAddress);
							row.find("#t3").text(n.message);
							row.find("#t4").text(parseDate(n.dt,"yyyy-MM-dd HH:mm:ss"));
							row.attr("id","ready");
							row.attr("class","goods_xqnr ready_all");
							row.appendTo("#tablelist");
					    });
						$("#pager a").remove();
						var showNumMin = 0;
						if(0<=modata.pagerNo<10) showNumMin = modata.pagerNo;
						else showNumMin = modata.pagerNo >= modata.pagerTotal-9 ? modata.pagerTotal-9 : modata.pagerNo;
						
						var showNumMax = modata.pagerNo+9 >= modata.pagerTotal ? modata.pagerTotal : modata.pagerNo+9;
						for(var i=showNumMin;i<=showNumMax;i++){
							if(i==modata.pagerNo)
								$("#pager").append("<a href='javascript:void(0)' style='color:red' onclick='mopage("+i+")'>【"+i+"】</a>");
							else{
								$("#pager").append("<a href='javascript:void(0)' onclick='mopage("+i+")'>【"+i+"】</a>");
							}
						}
						$("#nextpage").html("<a href='javascript:void(0)' onclick='mopage("+(modata.pagerNo+1)+")'>【下一页】</a>");
						$("#lastpage").html("<a href='javascript:void(0)' onclick='mopage("+modata.pagerTotal+")'>【末页】</a>");
						$("#showpage").html("共"+modata.count+"条      &nbsp;&nbsp;&nbsp;第【1】页/共【"+modata.pagerTotal+"】页");
						
					}
						
						// 下行
						var mtdata =msg.paList[1];
						if(mtdata!="")
						{
							$("#mttrlist").show();
							$(".ready_all_mt").remove();
							var mtlist = mtdata.list;
							$.each(mtlist,function(i,n){
								var row = $("#mttrlist").clone();
								row.find("#t11").text(n.senderName);
								row.find("#t21").text(n.productId);
								row.find("#t31").text(n.addresses);
								row.find("#t41").text(n.message);
								row.find("#t51").text(parseDate(n.dt,"yyyy-MM-dd HH:mm:ss"));
								row.attr("id","ready");
								row.attr("class","goods_xqnr ready_all_mt");
								row.appendTo("#mttablelist");
						    });
							$("#mtpager a").remove();
							var showNumMinmt = 0;
							if(0<=mtdata.pagerNo<10) showNumMinmt = mtdata.pagerNo;
							else showNumMinmt = mtdata.pagerNo >= mtdata.pagerTotal-9 ? mtdata.pagerTotal-9 : mtdata.pagerNo;
							
							var showNumMaxmt = mtdata.pagerNo+9 >= mtdata.pagerTotal ? mtdata.pagerTotal : mtdata.pagerNo+9;
							for(var j=showNumMinmt;j<=showNumMaxmt;j++){
								if(j==mtdata.pagerNo)
									$("#mtpager").append("<a href='javascript:void(0)' style='color:red' onclick='mtpage("+j+")'>【"+j+"】</a>");
								else{
									$("#mtpager").append("<a href='javascript:void(0)' onclick='mtpage("+j+")'>【"+j+"】</a>");
								}
							}
							$("#mtnextpage").html("<a href='javascript:void(0)' onclick='mtpage("+(mtdata.pagerNo+1)+")'>【下一页】</a>");
							$("#mtlastpage").html("<a href='javascript:void(0)' onclick='mtpage("+mtdata.pagerTotal+")'>【末页】</a>");
							$("#mtshowpage").html("共"+mtdata.count+"条      &nbsp;&nbsp;&nbsp;第【1】页/共【"+mtdata.pagerTotal+"】页");
						}
						
						//业务代码
						var pudata =msg.paList[2];
						if(pudata!="")
						{
							$("#putrlist").show();
							$(".ready_all_pu").remove();
							var pulist = pudata.list;
							$.each(pulist,function(i,n){
								var row = $("#putrlist").clone();
								row.find("#t12").text(n.id.productId);
								row.find("#t22").text(n.id.pn);
								row.find("#t32").text(n.status);
								row.find("#t42").text(parseDate(n.orderDate,"yyyy-MM-dd HH:mm:ss"));
								row.attr("id","ready");
								row.attr("class","goods_xqnr ready_all_pu");
								row.appendTo("#putablelist");
						    });
							$("#pupager a").remove();
							var showNumMinpu = 0;
							if(0<=pudata.pagerNo<10) showNumMinpu = pudata.pagerNo;
							else showNumMinpu = pudata.pagerNo >= pudata.pagerTotal-9 ? pudata.pagerTotal-9 : pudata.pagerNo;
							
							var showNumMaxpu = pudata.pagerNo+9 >= pudata.pagerTotal ? pudata.pagerTotal : pudata.pagerNo+9;
							for(var j=showNumMinpu;j<=showNumMaxpu;j++){
								if(j==pudata.pagerNo)
									$("#pupager").append("<a href='javascript:void(0)' style='color:red' onclick='pupage("+j+")'>【"+j+"】</a>");
								else{
									$("#pupager").append("<a href='javascript:void(0)' onclick='pupage("+j+")'>【"+j+"】</a>");
								}
							}
							$("#punextpage").html("<a href='javascript:void(0)' onclick='pupage("+(pudata.pagerNo+1)+")'>【下一页】</a>");
							$("#pulastpage").html("<a href='javascript:void(0)' onclick='pupage("+pudata.pagerTotal+")'>【末页】</a>");
							$("#pushowpage").html("共"+pudata.count+"条      &nbsp;&nbsp;&nbsp;第【1】页/共【"+pudata.pagerTotal+"】页");
						}
				}
				else
				{
				   $("#error").html("查询的内容不存在！");
				   $("#order_info_tab").css("display","none");
				}
		}});
		
		
		
	});
	
	
});


function mopage(i)
{
	$("#trlist").show();
	$(".ready_all").remove();
	
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	var telphone = $("#telphone").val();
	
	$.ajax({
		type:"get",
		dataType:"json",
		url:"query.do?startTime="+startTime+"&endTime="+endTime+"&telphone="+telphone+"&pagerNo="+i,
		complete:function(){$("#trlist").hide();},
		cache:false,
		success:function(msg)
		{
			if(msg.paList!=null)
			{
				//上行
				var modata =msg.paList[0];
				if(modata!="")
				{
					var molist = modata.list;
					$.each(molist,function(i,n){
						var row = $("#trlist").clone();
						row.find("#t1").text(n.smsServiceActivationNumber);
						row.find("#t2").text(n.senderAddress);
						row.find("#t3").text(n.message);
						row.find("#t4").text(parseDate(n.dt,"yyyy-MM-dd HH:mm:ss"));
						row.attr("id","ready");
						row.attr("class","goods_xqnr ready_all");
						row.appendTo("#tablelist");
				    });
					
					$("#pager a").remove();
					var showNumMin = 0;
					if(0<=modata.pagerNo<10) showNumMin = modata.pagerNo;
					else showNumMin = modata.pagerNo >= modata.pagerTotal-9 ? modata.pagerTotal-9 : modata.pagerNo;
					
					var showNumMax = modata.pagerNo+9 >= modata.pagerTotal ? modata.pagerTotal : modata.pagerNo+9;
					for(var i=showNumMin;i<=showNumMax;i++){
						if(i==modata.pagerNo)
							$("#pager").append("<a href='javascript:void(0)' style='color:red' onclick='mopage("+i+")'>【"+i+"】</a>");
						else{
							$("#pager").append("<a href='javascript:void(0)' onclick='mopage("+i+")'>【"+i+"】</a>");
						}
					}
					   if(modata.pagerNo!=1){
						$("#firstpage").html("<a href='javascript:void(0)' onclick='mopage(1)'>【首页】</a>");
						$("#prepage").html("<a href='javascript:void(0)' onclick='mopage("+(modata.pagerNo-1)+")'>【上一页】</a>");
					 	}
					 	if(modata.pagerNo==1){
					 		$("#firstpage a").remove();
					 		$("#prepage a").remove();
					 	}
					 	if(modata.pagerNo==modata.pagerTotal){
					 		$("#lastpage a").remove();
					 		$("#nextpage a").remove();
					 	}
					 	if(modata.pagerNo!=modata.pagerTotal){
					 		$("#nextpage").html("<a href='javascript:void(0)' onclick='mopage("+(modata.pagerNo+1)+")'>【下一页】</a>");
					 		$("#lastpage").html("<a href='javascript:void(0)' onclick='mopage("+modata.pagerTotal+")'>【末页】</a>");
					 	}
					 	$("#showpage").html("共"+modata.count+"条    &nbsp;&nbsp;&nbsp;第【"+modata.pagerNo+"】页/共【"+modata.pagerTotal+"】页");
					
				}
				
			}
			else
			{
			   $("#error").html("查询的内容不存在！");
			   $("#order_info_tab").css("display","none");
			}
	}});
	
}



function mtpage(i)
{
	$("#mttrlist").show();
	$(".ready_all_mt").remove();
	
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	var telphone = $("#telphone").val();
	
	$.ajax({
		type:"get",
		dataType:"json",
		url:"query.do?startTime="+startTime+"&endTime="+endTime+"&telphone="+telphone+"&mtpagerNo="+i,
		complete:function(){$("#mttrlist").hide();},
		cache:false,
		success:function(msg)
		{
			if(msg.paList!=null)
			{
				var mtdata =msg.paList[1];
				if(mtdata!="")
				{
					var mtlist = mtdata.list;
					$.each(mtlist,function(i,n){
						var row = $("#mttrlist").clone();
						row.find("#t11").text(n.senderName);
						row.find("#t21").text(n.productId);
						row.find("#t31").text(n.addresses);
						row.find("#t41").text(n.message);
						row.find("#t51").text(parseDate(n.dt,"yyyy-MM-dd HH:mm:ss"));
						row.attr("id","ready");
						row.attr("class","goods_xqnr ready_all_mt");
						row.appendTo("#mttablelist");
				    });
					
					$("#mtpager a").remove();
					
					var showNumMinmt = 0;
					if(0<=mtdata.pagerNo<10) showNumMinmt = mtdata.pagerNo;
					else showNumMinmt = mtdata.pagerNo >= mtdata.pagerTotal-9 ? mtdata.pagerTotal-9 : mtdata.pagerNo;
					
					var showNumMaxmt = mtdata.pagerNo+9 >= mtdata.pagerTotal ? mtdata.pagerTotal : mtdata.pagerNo+9;
					for(var i=showNumMinmt;i<=showNumMaxmt;i++){
						if(i==mtdata.pagerNo)
							$("#mtpager").append("<a href='javascript:void(0)' style='color:red' onclick='mtpage("+i+")'>【"+i+"】</a>");
						else{
							$("#mtpager").append("<a href='javascript:void(0)' onclick='mtpage("+i+")'>【"+i+"】</a>");
						}
					}
					
					   if(mtdata.pagerNo!=1){
						$("#mtfirstpage").html("<a href='javascript:void(0)' onclick='mtpage(1)'>【首页】</a>");
						$("#mtprepage").html("<a href='javascript:void(0)' onclick='mtpage("+(mtdata.pagerNo-1)+")'>【上一页】</a>");
					 	}
					 	if(mtdata.pagerNo==1){
					 		$("#mtfirstpage a").remove();
					 		$("#mtprepage a").remove();
					 	}
					 	if(mtdata.pagerNo==mtdata.pagerTotal){
					 		$("#mtlastpage a").remove();
					 		$("#mtnextpage a").remove();
					 	}
					 	if(mtdata.pagerNo!=mtdata.pagerTotal){
					 		$("#mtnextpage").html("<a href='javascript:void(0)' onclick='mtpage("+(mtdata.pagerNo+1)+")'>【下一页】</a>");
					 		$("#mtlastpage").html("<a href='javascript:void(0)' onclick='mtpage("+mtdata.pagerTotal+")'>【末页】</a>");
					 	}
					 	$("#mtshowpage").html("共"+mtdata.count+"条    &nbsp;&nbsp;&nbsp;第【"+mtdata.pagerNo+"】页/共【"+mtdata.pagerTotal+"】页");
					
				}
				
			}
			else
			{
			   $("#error").html("查询的内容不存在！");
			   $("#order_info_tab").css("display","none");
			}
	}});
	
}


function pupage(i)
{
	$("#putrlist").show();
	$(".ready_all_pu").remove();
	
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	var telphone = $("#telphone").val();
	
	$.ajax({
		type:"get",
		dataType:"json",
		url:"query.do?startTime="+startTime+"&endTime="+endTime+"&telphone="+telphone+"&bupagerNo="+i,
		complete:function(){$("#putrlist").hide();},
		cache:false,
		success:function(msg)
		{
			if(msg.paList!=null)
			{
				var pudata =msg.paList[2];
				if(pudata!="")
				{
					var pulist = pudata.list;
					$.each(pulist,function(i,n){
						var row = $("#putrlist").clone();
						row.find("#t12").text(n.id.productId);
						row.find("#t22").text(n.id.pn);
						row.find("#t32").text(n.status);
						row.find("#t42").text(parseDate(n.orderDate,"yyyy-MM-dd HH:mm:ss"));
						row.attr("id","ready");
						row.attr("class","goods_xqnr ready_all_pu");
						row.appendTo("#putablelist");
				    });
					$("#pupager a").remove();
					var showNumMinpu = 0;
					if(0<=pudata.pagerNo<10) showNumMinpu = pudata.pagerNo;
					else showNumMinpu = pudata.pagerNo >= pudata.pagerTotal-9 ? pudata.pagerTotal-9 : pudata.pagerNo;
					
					var showNumMaxpu = pudata.pagerNo+9 >= pudata.pagerTotal ? pudata.pagerTotal : pudata.pagerNo+9;
					for(var j=showNumMinpu;j<=showNumMaxpu;j++){
						if(j==pudata.pagerNo)
							$("#pupager").append("<a href='javascript:void(0)' style='color:red' onclick='pupage("+j+")'>【"+j+"】</a>");
						else{
							$("#pupager").append("<a href='javascript:void(0)' onclick='pupage("+j+")'>【"+j+"】</a>");
						}
					}
					
					   if(pudata.pagerNo!=1){
						$("#pufirstpage").html("<a href='javascript:void(0)' onclick='pupage(1)'>【首页】</a>");
						$("#puprepage").html("<a href='javascript:void(0)' onclick='pupage("+(pudata.pagerNo-1)+")'>【上一页】</a>");
					 	}
					 	if(pudata.pagerNo==1){
					 		$("#pufirstpage a").remove();
					 		$("#puprepage a").remove();
					 	}
					 	if(pudata.pagerNo==pudata.pagerTotal){
					 		$("#pulastpage a").remove();
					 		$("#punextpage a").remove();
					 	}
					 	if(pudata.pagerNo!=pudata.pagerTotal){
					 		$("#punextpage").html("<a href='javascript:void(0)' onclick='pupage("+(pudata.pagerNo+1)+")'>【下一页】</a>");
					 		$("#pulastpage").html("<a href='javascript:void(0)' onclick='pupage("+pudata.pagerTotal+")'>【末页】</a>");
					 	}
					 	$("#pushowpage").html("共"+pudata.count+"条    &nbsp;&nbsp;&nbsp;第【"+pudata.pagerNo+"】页/共【"+pudata.pagerTotal+"】页");
				}
			}
			else
			{
			   $("#error").html("查询的内容不存在！");
			   $("#order_info_tab").css("display","none");
			}
	}});
	
}



</script>

</head>
<body>

 <div id="queryTJ" align="center" style="font-size: 14px;font-weight: normal;font-family: '微软雅黑', verdana; padding-right: 130px;" >
	<table style="padding-top: 20px;">
	    <tr><td>短信查询：</td></tr>
		<tr height="30">
			<td align="right" class="leftLabel">开始日期：</td>
			<td><script language="javascript" type="text/javascript"
					src="js/My97DatePicker/WdatePicker.js"></script> <input
				class="Wdate" type="text" name="startTime"
				onClick="WdatePicker()" id="startTime" /></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td align="right" class="leftLabel">结束日期：</td>
			<td><input class="Wdate" type="text" onClick="WdatePicker()"
				name="endTime" id="endTime" onfocus="addate2()" /></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td align="right" class="leftLabel">手机号：</td>
			<td><input type="text" name="telphone" id="telphone" /></td>
			
			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td align="right" class="leftLabel">
			<input type="button" name="queryBtn" id="queryBtn" value="查询"/></td>
		</tr>
	</table>
	</div>
<div class="goods">
  <div class="goods_gap"></div>
  <div class="goods_bt">
 <div class="goods_left"><img src="images/chaxunye_07.png"/></div>
       <div class="goods_among goods_font_14"><div style="width:45px; height:29px; float:left;">上行</div><span style="width:200px; height:29px; float:left;" id="goods_id"></span></div>
       <div class="goods_both"><img src="images/chaxunye_07-2.png" /></div>
  </div>
  <table width="960" border="0" align="left" cellpadding="0" cellspacing="0" class="goods_biank">
  <tr>
    <td width="4" height="23" align="left" class="goods_details" style=" border-bottom: 1px solid #ccc;"></td>
    <td width="273" height="23" align="center" class="goods_details" style=" border-bottom: 1px solid #ccc;">服务号</td>
    <td width="273" align="center" class="goods_details" style=" border-bottom: 1px solid #ccc;">电话号码</td>
    <td width="273" align="center" class="goods_details" style=" border-bottom: 1px solid #ccc;">内容</td>
    <td width="273" height="23" align="center" class="goods_details" style=" border-bottom: 1px solid #ccc;">日期时间</td>
    <td width="4" height="23" align="right" class="goods_details" style=" border-bottom: 1px solid #ccc;"></td>
    </tr>
  <tr>
    <td height="30" colspan="6">
    <table width="958" border="0" align="left" cellpadding="0" cellspacing="2" class="goods_font_12" id="tablelist">
      <tr class="goods_xqnr" id="trlist">
        <td id="t1" width="240" height="30" align="center"></td>
        <td id="t2" width="240" height="30" align="center"></td>
        <td id="t3" width="240" height="30" align="center"></td>
        <td id="t4" width="240" height="30" align="center"></td>
      </tr>
    </table></td>
    </tr>
</table>
	<div style="font-size: 11px;font-weight: normal;font-family: '微软雅黑', verdana;text-decoration: none;">
		<span id="firstpage"></span>	
		<span id="prepage"></span>
		<span id="pager"></span>
		<span id="nextpage"></span>
		<span id="lastpage"></span>
		<span id="showpage"></span>
	</div>
<div class="goods_gap"></div>
<div id="error" style="color: red;padding-top: 10px;"></div>
</div>

<!-- 下行 -->
<div class="goods">
  <div class="goods_gap"></div>
  <div class="goods_bt">
 <div class="goods_left"><img src="images/chaxunye_07.png"/></div>
       <div class="goods_among goods_font_14"><div style="width:45px; height:29px; float:left;">下行</div><span style="width:200px; height:29px; float:left;" id="goods_id"></span></div>
       <div class="goods_both"><img src="images/chaxunye_07-2.png" /></div>
  </div>
  <table width="960" border="0" align="left" cellpadding="0" cellspacing="0" class="goods_biank">
  <tr>
    <td width="4" height="23" align="left" class="goods_details" style=" border-bottom: 1px solid #ccc;"></td>
    <td width="100" height="23" align="center" class="goods_details" style=" border-bottom: 1px solid #ccc;">服务号</td>
    <td width="150" align="center" class="goods_details" style=" border-bottom: 1px solid #ccc;">业务代码</td>
    <td width="100" align="center" class="goods_details" style=" border-bottom: 1px solid #ccc;">电话号码</td>
    <td width="500" align="center" class="goods_details" style=" border-bottom: 1px solid #ccc;">内容</td>
    <td width="150" height="23" align="center" class="goods_details" style=" border-bottom: 1px solid #ccc;">日期时间</td>
    <td width="4" height="23" align="right" class="goods_details" style=" border-bottom: 1px solid #ccc;"></td>
    </tr>
  <tr>
    <td height="30" colspan="6">
    <table width="958" border="0" align="left" cellpadding="0" cellspacing="2" class="goods_font_12" id="mttablelist">
      <tr class="goods_xqnr" id="mttrlist">
        <td id="t11" width="90" height="30" align="center"></td>
        <td id="t21" width="90" height="30" align="center"></td>
        <td id="t31" width="90" height="30" align="center"></td>
        <td id="t41" width="500" height="30" align="left"></td>
        <td id="t51" width="140" height="30" align="center"></td>
      </tr>
    </table></td>
    </tr>
</table>
<div style="font-size: 11px;font-weight: normal;font-family: '微软雅黑', verdana;text-decoration: none;">
		<span id="mtfirstpage"></span>	
		<span id="mtprepage"></span>
		<span id="mtpager"></span>
		<span id="mtnextpage"></span>
		<span id="mtlastpage"></span>
		<span id="mtshowpage"></span>
	</div>
<div class="goods_gap"></div>
<div id="error" style="color: red;padding-top: 10px;"></div>
</div>


<!-- 业务查询 -->
<div class="goods">
  <div class="goods_gap"></div>
  <div class="goods_bt">
 <div class="goods_left"><img src="images/chaxunye_07.png"/></div>
       <div class="goods_among goods_font_14">业务代码
</div>
       <div class="goods_both"><img src="images/chaxunye_07-2.png" /></div>
  </div>
  <table width="960" border="0" align="left" cellpadding="0" cellspacing="0" class="goods_biank">
  <tr>
    <td width="4" height="23" align="left" class="goods_details" style=" border-bottom: 1px solid #ccc;"></td>
    <td width="273" height="23" align="center" class="goods_details" style=" border-bottom: 1px solid #ccc;">服务号</td>
    <td width="273" align="center" class="goods_details" style=" border-bottom: 1px solid #ccc;">电话号码</td>
    <td width="273" align="center" class="goods_details" style=" border-bottom: 1px solid #ccc;">状态</td>
    <td width="273" height="23" align="center" class="goods_details" style=" border-bottom: 1px solid #ccc;">日期时间</td>
    <td width="4" height="23" align="right" class="goods_details" style=" border-bottom: 1px solid #ccc;"></td>
    </tr>
  <tr>
    <td height="30" colspan="6">
    <table width="958" border="0" align="left" cellpadding="0" cellspacing="2" class="goods_font_12" id="putablelist">
      <tr class="goods_xqnr" id="putrlist">
        <td id="t12" width="240" height="30" align="center"></td>
        <td id="t22" width="240" height="30" align="center"></td>
        <td id="t32" width="240" height="30" align="center"></td>
        <td id="t42" width="240" height="30" align="center"></td>
      </tr>
    </table></td>
    </tr>
</table>
<div style="font-size: 11px;font-weight: normal;font-family: '微软雅黑', verdana;text-decoration: none;">
		<span id="pufirstpage"></span>	
		<span id="puprepage"></span>
		<span id="pupager"></span>
		<span id="punextpage"></span>
		<span id="pulastpage"></span>
		<span id="pushowpage"></span>
	</div>
<div class="goods_gap"></div>
<div id="error" style="color: red;padding-top: 10px;"></div>
</div>

</body>
</html>