jQuery.sap.declare("nfeapp.WebContent.util.Formatter");

jQuery.sap.require("sap.ui.core.format.DateFormat");

nfeapp.WebContent.util.Formatter = {

	_statusStateMap : {
		"P" : "Success",
		"N" : "Warning"
	},

	statusText :  function (value) {
		var bundle = this.getModel("i18n").getResourceBundle();
		return bundle.getText("StatusText" + value, "?");
	},

	statusState :  function (value) {
		var map = nfeapp.WebContent.util.Formatter._statusStateMap;
		return (value && map[value]) ? map[value] : "None";
	},

	date : function (value) {
		if (value) {
			var oDateFormat = sap.ui.core.format.DateFormat.getDateTimeInstance({pattern: "yyyy-MM-dd"}); 
			var year = value.substring(0,4);
			var month = value.substring(4,6);
			var day = value.substring(6,8);
			return oDateFormat.format(new Date(year, month, day));
		} else {
			return value;
		}
	},

	quantity :  function (value) {
		try {
			return (value) ? parseFloat(value).toFixed(0) : value;
		} catch (err) {
			return "Not-A-Number";
		}
	},
	
	CFOP : function (value) {
		try{
			//var cfop = substring(value,1,4);
			return (value) ? substring(value,1,4) : value;
		} catch (err){
			return "Not-A-CFOP'";
		}
	}
};