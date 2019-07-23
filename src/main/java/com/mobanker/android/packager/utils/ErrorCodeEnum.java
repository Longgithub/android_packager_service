package com.mobanker.android.packager.utils;

public enum ErrorCodeEnum{
	 SYS_OK("1","处理成功！")
	,PARAM_IS_NULL(ErrorCodeEnum.ERROR_CODE+1,"id为空")
	,ERROR_SEND_CODE(ErrorCodeEnum.ERROR_CODE+2,"验证码发送失败")
	,ERROR_CHECK_CODE(ErrorCodeEnum.ERROR_CODE+3,"验证码校验未通过")
    ,PARAMS_ILLEGE(ErrorCodeEnum.ERROR_CODE+000004,"参数错误")
    ,PARAMS_PHONE(ErrorCodeEnum.ERROR_CODE+5,"手机号参数缺失!")
    ,PARAMS_CAPTCHA(ErrorCodeEnum.ERROR_CODE+6,"验证码参数缺失!")
    ,ERROR_EXIST_PHONE(ErrorCodeEnum.ERROR_CODE+7, "该手机号码已被注册!")
    ,ERROR_CODEID(ErrorCodeEnum.ERROR_CODE+8, "codeId为空!")
    ,PARAMS_PHONE_ERROR(ErrorCodeEnum.ERROR_CODE+9,"手机号参数缺失!"),
    ERROR_PARAMS_GET_IMGCODE(ErrorCodeEnum.ERROR_CODE+10, "获取Banner信息失败!"),
	SYS_EXCEPTION(ErrorCodeEnum.ERROR_CODE+ 11,"系统发生异常错误!"),
	//0704新增
	TOKEN_DATA_ERROR(ErrorCodeEnum.ERROR_CODE+100, "token参数异常!"),
	TOKEN_IMPL_ERROR(ErrorCodeEnum.ERROR_CODE+101, "会话异常，请重新登录"),
	ENUM_ERROR(ErrorCodeEnum.ERROR_CODE+102, "枚举值异常"),
	PARAM_VALUE_ERROR(ErrorCodeEnum.ERROR_CODE+103, "参数值异常"),
	PERMISSION_ERROR(ErrorCodeEnum.ERROR_CODE+104, "您无权操作"),
	TEMPLATE_BINGED_ERROR(ErrorCodeEnum.ERROR_CODE+105, "模板已被绑定不能删除"),
	NO_PRODUCT_NEEDBING_ERROR(ErrorCodeEnum.ERROR_CODE+106, "没有需要绑定的产品和类别"),
	COPY_PRODUCT_ERROR(ErrorCodeEnum.ERROR_CODE+107, "产品复制发生异常"),
	DELETE_PRODUCT_ERROR(ErrorCodeEnum.ERROR_CODE+108, "删除产品发生异常"),
	PUTAWAY_PRODUCT_ERROR(ErrorCodeEnum.ERROR_CODE+109, "产品上架发生异常"),
	REPEAL_PRODUCT_ERROR(ErrorCodeEnum.ERROR_CODE+110, "产品下架发生异常"),
	MESSAGE_INPUT_ERROR(ErrorCodeEnum.ERROR_CODE+111, "短信模板内容错误"),


	PRODUCT_NAME_REPEAT(ErrorCodeEnum.ERROR_CODE + 200,"产品名称已存在!"),
	PRODUCT_ID_NULL(ErrorCodeEnum.ERROR_CODE + 201,"产品id不能为空!"),
	PAGE_INFO_EXCEPTION(ErrorCodeEnum.ERROR_CODE + 202,"分页参数有误!"),
	PRODUCT_EDIT_EXCEPTION(ErrorCodeEnum.ERROR_CODE + 203,"编辑产品发生异常错误!"),
	CHANNEL_EDIT_EXCEPTION(ErrorCodeEnum.ERROR_CODE + 204,"编辑渠道号信息发生错误！"),
	CHANNEL_ADD_EXCEPTION(ErrorCodeEnum.ERROR_CODE + 205,"保存渠道号信息发生错误！"),
	TEMPLATE_ADD_EXCEPTION(ErrorCodeEnum.ERROR_CODE + 206,"保存模板信息发生错误！"),
	TEMPLATE_NAME_REPEAT(ErrorCodeEnum.ERROR_CODE + 207,"模板名称已存在！"),
	BANNER_VALID_ERROR(ErrorCodeEnum.ERROR_CODE + 208,"操作失败！"),
	CHANNEL_DELETE_ERROR(ErrorCodeEnum.ERROR_CODE + 209,"删除失败！"),
	BANNER_IN_USE(ErrorCodeEnum.ERROR_CODE + 210,"banner正在使用，不能下线！"),
	BANNER_IN_REGISTER(ErrorCodeEnum.ERROR_CODE + 211,"获取banner信息失败!"),
	YOUJIE_IN_REGISTER(ErrorCodeEnum.ERROR_CODE + 212,"获取产品列表失败!"),
	YOUJIE_INFO_REGISTER(ErrorCodeEnum.ERROR_CODE + 213,"获取产品信息失败!"),
	PRODUCT_INFO_EXCEPTION(ErrorCodeEnum.ERROR_CODE + 214,"查询产品详情错误!"),
	PARAM_INFO_EXCEPTION(ErrorCodeEnum.ERROR_CODE + 215,"缺少必填参数!"),
	USER_INFO_EXCEPTION(ErrorCodeEnum.ERROR_CODE + 216,"用户名或密码不能为空!"),
	PRODUCT_ADD_EXCEPTION(ErrorCodeEnum.ERROR_CODE + 217,"新增产品发生异常错误!"),
	CHANNEL_REPEAT_EXCEPTION(ErrorCodeEnum.ERROR_CODE + 218,"渠道号不能重复!"),
	PRODUCT_STICK_EXCEPTION(ErrorCodeEnum.ERROR_CODE + 219,"置顶产品发生异常!"),
	FIND_TEMPLATE_EXCEPTION(ErrorCodeEnum.ERROR_CODE + 220,"产品获取模板失败!"),
	PRODUCT_SORT_EXCEPTION(ErrorCodeEnum.ERROR_CODE + 221,"更改产品排序发生异常错误!"),
	COMMON_TEMPLATE_ERROR(ErrorCodeEnum.ERROR_CODE+ 222,"通用模板不能删除!"),
	COMMON_TEMPLATE1_ERROR(ErrorCodeEnum.ERROR_CODE+ 223,"通用模板不能修改!"),
	CHANNEL_ERROR(ErrorCodeEnum.ERROR_CODE + 224, "错误，请修改!"),
	CHANNEL_REPEAT_USE(ErrorCodeEnum.ERROR_CODE + 225, "已关联其他页面，是否确认更新？"),
	CREDITCARD_DELETEFLAG_ERROR(ErrorCodeEnum.ERROR_CODE + 226,"上下架标志值只能0或1"),
	TRADE_REFUND_ERROR(ErrorCodeEnum.ERROR_CODE + 227,"运营小姐姐们，请再核实一下这几个订单号呗！"),
	TRADE_REFUND_NID_ERROR(ErrorCodeEnum.ERROR_CODE + 228,"退费nid异常！"),
	TRADE_REFUND_MODO_ERROR(ErrorCodeEnum.ERROR_CODE + 229,"运营小姐姐们，你们使用的退费模板异常啦，请核实一下呗！"),
	TRADE_REFUND_MODO_NULL_ERROR(ErrorCodeEnum.ERROR_CODE + 230,"运营小姐姐们，你们传的是空模板啊！"),
	MODO_ERROR(ErrorCodeEnum.ERROR_CODE + 231, "模板异常！"),
	MODO_TYPE_ERROR(ErrorCodeEnum.ERROR_CODE + 232, "只能上传xls(x)格式文件!"),
	IMGDESC_ERROR(ErrorCodeEnum.ERROR_CODE + 233, "图片描述已存在，请修改"),
	QUERY_AGENT_PRODUCT_LIST_ERROR(ErrorCodeEnum.ERROR_CODE + 300,"获取产品代理列表失败!"),
	ADD_AGENT_PRODUCT_ERROR(ErrorCodeEnum.ERROR_CODE + 3010,"新增产品代理失败!"),
	EDIT_AGENT_PRODUCT_ERROR(ErrorCodeEnum.ERROR_CODE + 302,"修改产品代理列表失败!"),
	QUERY_AGENT_PRODUCT_INFO_ERROR(ErrorCodeEnum.ERROR_CODE + 303,"获取产品代理详情失败!"),
	SORT_AGENT_PRODUCT_ERROR(ErrorCodeEnum.ERROR_CODE + 304,"产品代理排序修改失败!"),
	SORT_PARAM_ERROR(ErrorCodeEnum.ERROR_CODE + 306,"排序传入参数错误!"),
	ON_OR_OFF_SHELF_ERROR(ErrorCodeEnum.ERROR_CODE + 305,"代理产品上下架失败!"),
	ON_OR_OFF_SHELF_PARAM_ERROR(ErrorCodeEnum.ERROR_CODE + 306,"上下架传入参数错误!"),

	QUERY_AGENT_INFO_LIST_ERROR(ErrorCodeEnum.ERROR_CODE + 307,"获取代理佣金列表信息失败!"),
	ADD_AGENT_INFO_ERROR(ErrorCodeEnum.ERROR_CODE + 308,"新增代理佣金信息失败!"),
	EDIT_AGENT_INFO_ERROR(ErrorCodeEnum.ERROR_CODE + 309,"修改代理佣金信息失败!"),
	QUERY_AGENT_INFO_ERROR(ErrorCodeEnum.ERROR_CODE + 310,"获取代理佣金信息失败!"),
	DELETE_AGENT_INFO_ERROR(ErrorCodeEnum.ERROR_CODE + 311,"删除代理佣金信息失败!"),

	QUERY_AGENT_CREDIT_CARD_LIST_ERROR(ErrorCodeEnum.ERROR_CODE + 312,"获取信用卡代理列表失败!"),
	ADD_AGENT_CREDIT_CARD_ERROR(ErrorCodeEnum.ERROR_CODE + 313,"新增信用卡代理失败!"),
	EDIT_AGENT_CREDIT_CARD_ERROR(ErrorCodeEnum.ERROR_CODE + 314,"修改信用卡代理列表失败!"),
	QUERY_AGENT_CREDIT_CARD_INFO_ERROR(ErrorCodeEnum.ERROR_CODE + 315,"获取信用卡代理详情失败!"),
	SORT_AGENT_CREDIT_CARD_ERROR(ErrorCodeEnum.ERROR_CODE + 316,"信用卡代理排序失败!"),

	QUERY_LIST_INFORMATION_ERROR(ErrorCodeEnum.ERROR_CODE + 317,"获取资讯信息列表失败!"),
	ADD_INFORMATION_ERROR(ErrorCodeEnum.ERROR_CODE + 318,"新增资讯信息失败!"),
	EDIT_INFORMATION_ERROR(ErrorCodeEnum.ERROR_CODE + 319,"编辑资讯信息失败!"),
	QUERY_DETAIL_INFORMATION_ERROR(ErrorCodeEnum.ERROR_CODE + 320,"获取资讯信息详情失败!"),
	SET_TOP_INFORMATION_ERROR(ErrorCodeEnum.ERROR_CODE + 321,"资讯信息置顶失败!"),
	ON_OR_OFF_SHELF_INFORMATION_ERROR(ErrorCodeEnum.ERROR_CODE + 322,"资讯上下架失败!"),
	CONTENT_CONVERT_INFORMATION_ERROR(ErrorCodeEnum.ERROR_CODE + 323,"资讯内容转换失败!"),
	PREVIEW_INFORMATION_ERROR(ErrorCodeEnum.ERROR_CODE + 323,"预览资讯 信息失败!"),
	JPUSH_INFORMATION_ERROT(ErrorCodeEnum.ERROR_CODE + 323,"推送资讯信息失败!"),
	JPUSH_INFORMATION_ISPUSHED(ErrorCodeEnum.ERROR_CODE + 324,"该条资讯已推送!"),
	ADD_OR_CANCLE_TO_FRONT_ERROR(ErrorCodeEnum.ERROR_CODE + 325,"添加或取消资讯到淘金客首页失败!"),

	QUERY_LIST_HOMEPAGE_ADS_ERROR(ErrorCodeEnum.ERROR_CODE + 600,"获取首页广告列表失败!"),
	ADD_HOMEPAGE_ADS_ERROR(ErrorCodeEnum.ERROR_CODE + 601,"新增首页广告失败!"),
	EDIT_HOMEPAGE_ADS_ERROR(ErrorCodeEnum.ERROR_CODE + 602,"修改首页广告失败!"),
	QUERY_HOMEPAGE_ADS_ERROR(ErrorCodeEnum.ERROR_CODE + 603,"获取首页广告详情失败!"),
	EXISTED_HOMEPAGE_ADS_POSITION(ErrorCodeEnum.ERROR_CODE + 604,"已存在该位置的首页广告!"),

	JJP_ERROR(ErrorCodeEnum.ERROR_CODE + 231,"拒就赔申请列表查询异常"),

	TASK_REGISTRATION_TEN_MINUTES_ERROR(ErrorCodeEnum.ERROR_CODE + 701,"注册十分钟后定时任务执行失败"),
	TASK_REGISTRATION_HOURS_ERROR(ErrorCodeEnum.ERROR_CODE + 702,"注册24小时后定时任务执行失败"),
	TASK_JPUSH_ERROR(ErrorCodeEnum.ERROR_CODE + 703,"全量用户推送失败"),

	SHARE_ADD_ERROR(ErrorCodeEnum.ERROR_CODE + 704,"新增文案配置失败"),
	SHARE_EDIT_ERROR(ErrorCodeEnum.ERROR_CODE + 705,"编辑文案配置失败"),
	SHARE_ADD_EXIST_ERROR(ErrorCodeEnum.ERROR_CODE + 706,"文案已经存在，请勿重复添加"),
	PARM_CHANNELPOINT_NULL_ERROR(ErrorCodeEnum.ERROR_CODE + 800,"渠道跳转参数为空"),
	CHANNELCODE_NOEXIST_ERROR(ErrorCodeEnum.ERROR_CODE + 801,"该渠道号不存在"),
	CHANNELCODE_REPEAT_ERROR(ErrorCodeEnum.ERROR_CODE + 803,"指向渠道和原始渠道相同"),
	CHANNELPOINT_EXIST_ERROR(ErrorCodeEnum.ERROR_CODE + 802,"该渠道跳转信息已添加过"),
	DIAN_HU_EXCEL_ERROR(ErrorCodeEnum.ERROR_CODE + 901,"电呼表格生成失败"),
	DIAN_HU_NULL(ErrorCodeEnum.ERROR_CODE + 902,"查询数据为空"),
	Vip_Member_EXCEL_ERROR(ErrorCodeEnum.ERROR_CODE + 903,"成功支付表格生成失败"),
	Vip_Member_NULL(ErrorCodeEnum.ERROR_CODE + 904,"查询成功支付数据为空"),
	Vip_History_Member_NULL(ErrorCodeEnum.ERROR_CODE + 905,"查询成功支付历史数据为空"),
	PACK_MONEY_ERROR(ErrorCodeEnum.ERROR_CODE + 906,"包下款异常"),
	COMMSION_PAY_URL_NULL(ErrorCodeEnum.ERROR_CODE + 907,"钱陛下佣金支付链接地址为空"),
	SETTLEMENT_EXCEPTION_ERROR(ErrorCodeEnum.ERROR_CODE + 908,"分销异常错误"),
	SETTLEMENT_CHANNEL_REPATE_ERROR(ErrorCodeEnum.ERROR_CODE + 909,"该渠道号已经添加过"),
	SETTLEMENT_NAME_REPATE_ERROR(ErrorCodeEnum.ERROR_CODE + 910,"该结算方已存在"),
	ACCOUNT_NO_REPATE_ERROR(ErrorCodeEnum.ERROR_CODE + 910,"账号已存在"),
	ACCOUNT_LOGIN_ERROR(ErrorCodeEnum.ERROR_CODE + 911,"账号或密码错误"),
	ACCOUNT_LOGIN_TIME_OUT_ERROR(ErrorCodeEnum.ERROR_CODE + 912,"登录已过期"),
	ACCOUNT_NOT_EXIST_ERROR(ErrorCodeEnum.ERROR_CODE + 913,"账号不存在"),
	DELETE_CHANNEL_NOT_EXIST_ERROR(ErrorCodeEnum.ERROR_CODE + 914,"下架渠道为空"),
	DELETE_EXCEL_UPLOAD_ERROR(ErrorCodeEnum.ERROR_CODE + 915,"下架渠道表格生成失败"),
	FLOOR_DELETE_ERROR(ErrorCodeEnum.ERROR_CODE + 916,"楼层不存在或已删除"),
	FLOOR_EXCEPTION_ERROR(ErrorCodeEnum.ERROR_CODE + 917,"楼层异常错误"),
	HOT_AREA_EXCEPTION_ERROR(ErrorCodeEnum.ERROR_CODE + 918,"热区异常错误"),
	DETAIL_NAME_REPATE_ERROR(ErrorCodeEnum.ERROR_CODE + 919,"渠道明细名称重复"),
	NO_DATA_ERROR(ErrorCodeEnum.ERROR_CODE + 920,"无上传数据"),

	XIAOBAI_ERROR(ErrorCodeEnum.ERROR_CODE + 501,"查询条件数据列表异常"),
	NO_PRODUCT_TAG_DESC(ErrorCodeEnum.ERROR_CODE + 921,"商品标签描述不能为空"),
	PRODUCT_TAG_DESC_ERROR(ErrorCodeEnum.ERROR_CODE + 922,"商品标签描述不能超出8个字符"),
	NOT_FIND_PHONE_INFO(ErrorCodeEnum.ERROR_CODE + 923,"未查询到手机号信息"),
	NOT_PAY_INFO(ErrorCodeEnum.ERROR_CODE + 924,"该功能只支持已付费用户的查询"),
	NOT_PAY_INFO_BEFORE(ErrorCodeEnum.ERROR_CODE + 925,"该用户在2018年10月后，没有过付费行为"),
	CONFIGTAB_ERROR(ErrorCodeEnum.ERROR_CODE + 502,"配置专区接口异常"),
	CONFIGTAB_INSERT_ERROR(ErrorCodeEnum.ERROR_CODE + 503,"应用类型已存在不可新增")

	;

	/**
	 * 默认ERROR_CODE.<br>
	 * 按公司要求8位长度，前两位产品。
     *
	 */
    public static final String ERROR_CODE="01000";

    private String code;
    private String message;

    private ErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

	public String getCode() {
		// TODO Auto-generated method stub
		return code;
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
}
