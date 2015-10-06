/**
 * 
 */


wx.ready(function() {
	document.querySelector('#checkJsApi').onclick = function() {
		wx.checkJsApi({
			jsApiList : [ 'getNetworkType', 'previewImage', 'scanQRCode' ],
			success : function(res) {
				alert(JSON.stringify(res));
			}
		});
		// config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
	};
	//9.1.1 扫描二维码并返回结果
	document.querySelector('#scanQRCode0').onclick = function() {
		wx.scanQRCode();
	};
	// 9.1.2 扫描二维码并返回结果
	document.querySelector('#scanQRCode1').onclick = function() {
		wx.scanQRCode({
			needResult : 1, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果，
			scanType : [ "qrCode", "barCode" ], // 可以指定扫二维码还是一维码，默认二者都有
			success : function(res) {
				var result = res.resultStr; // 当needResult 为 1 时，扫码返回的结果
				alert(JSON.stringify(res));
			}
		});
	}
});
wx.error(function(res) {
	// config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。

});