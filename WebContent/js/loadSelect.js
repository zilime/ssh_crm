function loadSelect(selectName, typecode, selectid, dictid) {

	var $select = $("<select name=" + selectName + "></select>");
	$select.append($("<option value=''>-请选择-</option>"));
	$.post("${pageContext.request.contextPath }/BaseDictAction", {
		dict_type_code : typecode
	}, function(data) {

		$.each(data, function(i, json) {

			$option = $("<option value='" + json["dict_id"] + "'>"
					+ json["dict_item_name"] + "</option>");
			if (json["dict_id"] == dictid) {
				$option.attr("selected", "selected");

			}

			$select.append($option);

		});

	}, "json");

	$("#" + selectid).append($select);

}