package apiPort;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @Auther: 狼芒
 * @Date: 2021/2/21 21:59
 * @Descrintion: 支付宝支付接口
 * @version: 1.0
 */
@Controller
public interface AlipayPort {

    /**
     * @Method:调用手机APP收款接口，可拉起手机支付
     * @param tradeNo  商户订单号。64 个字符以内的大小，可包含字母、数字、下划线。需保证该参数在商户端不重复，若重复显示同一个订单
     * @param subject 商品标题/交易标题/订单标题/订单关键字等。  注意：不可使用特殊字符，如 /，=，& 等。
     * @param tradeInfo 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加
     * @param timeOut 此处只能为分钟,该笔订单允许的最晚付款时间，逾期将关闭交易。
     * @param totalAmount 订单总金额，单位为人民币（元），取值范围为 0.01~100000000.00，精确到小数点后两位。
     * @param goodsType 商品主类型，取值如下：0：虚拟类商品；1：实物类商品。
     * @return 获取手机支付表单
     */
    @RequestMapping("createAppForm/{secret}/{tradeNo}/{subject}/{tradeInfo}/{timeOut}/{totalAmount}/{goodsType}")
    public Map<String,Object> getPermissionInfos();


    /**
     * @Method:调用wab收款接口
     * @param tradeNo  商户订单号。64 个字符以内的大小，可包含字母、数字、下划线。需保证该参数在商户端不重复，若重复显示同一个订单
     * @param subject 商品标题/交易标题/订单标题/订单关键字等。  注意：不可使用特殊字符，如 /，=，& 等。
     * @param tradeInfo  具体描述信息。如果是多种商品，请将商品描述字符串累加
     * @param timeOut 此处只能为分钟,该笔订单允许的最晚付款时间，逾期将关闭交易
     * @param totalAmount 订单总金额，单位为元，精确到小数点后两位，取值范围为 [0.01,100000000]。金额不能为0。
     * @param goodsType 商品主类型，取值如下：0：虚拟类商品；1：实物类商品。
     * @return 获取网站支付表单
     */
    @RequestMapping("createWebForm/{secret}/{tradeNo}/{subject}/{tradeInfo}/{timeOut}/{totalAmount}/{goodsType}")
    public String createWebForm();


    /**
     * @Method:查询订单状态
     * @param tradeNo 订单支付时传入的商户订单号
     * @return 返回订单交易信息
     */
    @RequestMapping("queryTradeByTradeNo/{secret}/{tradeNo}")
    public String queryTradeByTradeNo();


    /**
     * @Method:退款
     * @param outTradeNo 订单支付时传入的商户订单号，商家自定义且保证商家系统中唯一。与支付宝交易号 trade_no 不能同时为空。
     * @param refundAmount 需要退款的金额，该金额不能大于订单金额,单位为元，支持两位小数
     * @param refundReason 退款原因说明，商家自定义。
     * @param outRequestNo 标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传。
     * @param operatorId 商户的操作员编号
     * @return 返回退款信息——json格式
     */
    @RequestMapping("refundTradeByOutTradeNo/{secret}/{outTradeNo}/{refundAmount}/{refundReason}/{outRequestNo}/{operatorId}")
    public String refundTradeByOutTradeNo();

    /**
     * @Method:退款查询
     * @param outTradeNo 订单支付时传入的商户订单号,和支付宝交易号不能同时为空。 trade_no,out_trade_no如果同时存在优先取trade_no
     * @param outRequestNo 请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号
     * @return 返回退款后的详细信息
     */
    @RequestMapping("queryTradeByTradeNo/{secret}/{outTradeNo}/{outRequestNo}")
    public String queryRefundByTradeNo();

}
