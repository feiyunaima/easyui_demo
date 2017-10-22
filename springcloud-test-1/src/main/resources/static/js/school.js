$(function(){
	$('#school').datagrid(	{
		url:'getSchool',
		//fit : true,  //想让高度自适应，但是这个不管用我就操了。
		height:600,
		rownumbers : true,
		pagination : true,  //pagination	boolean	设置为 true，则在数据网格（datagrid）底部显示分页工具栏。
		pageSize : 10,
		pageList : [10, 20, 30, 40, 50],
		pageNumber : 1,
		sortName : 'id',
		sortOrder : 'desc',
		toolbar : '#school_tool',
		columns : [[
			{
				field : 'id',
				title : '自动编号',
				width : 100,
				checkbox : true,
			},
			{
				field : 'name',
				title : '学校名称',
				width : 100,
			}
		]],
	});

	school_tool = {
		reload : function () {
			console.log('reload');
			$('#school').datagrid('reload');
		},
		redo : function () {
			console.log('redo');
			$('#school').datagrid('unselectAll');
		},
		add : function () {
			$('#school_add').dialog('open');
			$('input[name="school"]').focus();
		},
		remove : function () {
			console.log('remove');
			var rows = $('#school').datagrid('getSelections');
			if (rows.length > 0) {
				$.messager.confirm('确定操作', '您正在要删除所选的记录吗？', function (flag) {
					if (flag) {
						var ids = [];
						for (var i = 0; i < rows.length; i ++) {
							ids.push(rows[i].id);
						}
						console.log(ids.join(','));
						$.ajax({
							type : 'POST',
							url : 'deleteSchool',
							data : {
								ids : ids.join(',')
							},
							success : function (result) {
								if (result.cussess) {
									$('#school').datagrid('loaded');
									$('#school').datagrid('load');
									$('#school').datagrid('unselectAll');
									$.messager.show({
										title : '提示',
										msg : data + '个管理被删除成功！',
									});
								}else{
									$('#school').datagrid('loaded');
									$('#school').datagrid('load');
									$('#school').datagrid('unselectAll');
									$.messager.alert('错误',result.msg,'error');
								}
							},
						});
					}
				});
			} else {
				$.messager.alert('提示', '请选择要删除的记录！', 'info');
			}
		},
		edit : function () {
			console.log('edit');
			var rows = $('#school').datagrid('getSelections');
			if (rows.length > 1) {
				$.messager.alert('警告操作！', '编辑记录只能选定一条数据！', 'warning');
			} else if (rows.length == 1) {
				console.log('edit2');
				$('#school_edit').form('load', {
					id : rows[0].id,
					name : rows[0].name,
				}).dialog('open');
			} else if (rows.length == 0) {
				$.messager.alert('警告操作！', '编辑记录至少选定一条数据！', 'warning');
			}
		}
	};

	$('#school_add').dialog({
		width : 350,
		title : '新增管理',
		modal : true,
		closed : true,
		iconCls : 'icon-user-add',
		buttons : [{
			text : '提交',
			iconCls : 'icon-add-new',
			handler : function () {
				var school_add_name = $('#school_add_name').val();
				console.log("学校名称是"+school_add_name);
					$.ajax({
						url : 'addSchool',
						type : 'post',
						data : {
							name : school_add_name,
						},
						success : function (result) {
							console.log(result);
							if (result.success) {
								$.messager.show({
									title : '提示',
									msg : '新增管理成功',
								});
								$('#school_add').dialog('close').form('reset');
								$('#school').datagrid('reload');
							} else {
								$.messager.alert('新增失败！', result.msg, 'warning');
							}
						}
					});

			},
		},{
			text : '取消',
			iconCls : 'icon-redo',
			handler : function () {
				$('#school_add').dialog('close').form('reset');
			},
		}],
	});

	$('#school_edit').dialog({
		width : 350,
		title : '修改管理',
		modal : true,
		closed : true,
		iconCls : 'icon-user-add',
		buttons : [{
			text : '提交',
			iconCls : 'icon-edit-new',
			handler : function () {
					$.ajax({
						url : 'updateSchool',
						type : 'post',
						data : {
							id : $('input[name="id"]').val(),
							name : $('input[name="name"]').val()
						},
						success : function (result) {
							if (result.success) {
								$.messager.show({
									title : '提示',
									msg : '修改成功',
								});
								$('#school_edit').dialog('close').form('reset');
								$('#school').datagrid('reload');
							} else {
								$.messager.alert('修改失败', result.msg, 'warning');
							}
						}
					});

			},
		},{
			text : '取消',
			iconCls : 'icon-redo',
			handler : function () {
				$('#school_edit').dialog('close').form('reset');
			},
		}],
	});

})