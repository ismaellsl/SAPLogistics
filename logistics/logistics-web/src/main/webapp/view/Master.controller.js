jQuery.sap.require("nfeapp.WebContent.util.Formatter");

sap.ui.controller("nfeapp.WebContent.view.Master", {
	
	onBeforeRendering:function(){
//		var filters = [];
//		var filter = new sap.ui.model.Filter("FORM", sap.ui.model.FilterOperator.EQ, "NF55");
//		filters.push(filter);
//		var list = this.getView().byId("list");
//		var binding = list.getBinding("items");
//		binding.filter(filters);
	},
	
	handleListItemPress : function (evt) {
		var context = evt.getSource().getBindingContext();
		this.nav.to("Detail", context);
	},

	handleSearch : function (evt) {

		// create model filter
		var filters = [];
		var query = evt.getParameter("query");
		if (query && query.length > 0) {
			var filter = new sap.ui.model.Filter("DOCNUM", sap.ui.model.FilterOperator.Contains, query);
			filters.push(filter);
		}

		// update list binding
		var list = this.getView().byId("list");
		var binding = list.getBinding("items");
		binding.filter(filters);
	},

	handleListSelect : function (evt) {
		var context = evt.getParameter("listItem").getBindingContext();
		this.nav.to("Detail", context);
	},

});