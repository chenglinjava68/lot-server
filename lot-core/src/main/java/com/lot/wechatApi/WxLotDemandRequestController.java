package com.lot.wechatApi;

import com.lot.service.LotDemandRequestService;
import com.lot.util.Msg;
import com.lot.vo.lotDemandRequest.LotDemandRequestSaveVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/lot/weixin/notdirectly/demandrequest")
public class WxLotDemandRequestController {
    @Autowired
    private LotDemandRequestService lotDemandRequestService;

    // 把"" 转化成null
    @InitBinder
    public void bind(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

//    @PostMapping("/findlist")
//    @ApiOperation("微信获取需求请求列表")
//    public Msg findList(@RequestBody LotDemandRequestSearchVo searchVo){
//        return lotDemandRequestService.findList(searchVo);
//    }

//    @GetMapping("/get")
//    @ApiOperation("微信获取单个需求请求")
//    public Msg get(@RequestParam String demandRequestId){
//        return Msg.success().add("demandRequest",lotDemandRequestService.get(demandRequestId));
//    }

    @PostMapping("/save")
    @Transactional
    @ApiOperation("微信保存需求请求")
    public Msg save(@RequestBody LotDemandRequestSaveVo saveVo){
        lotDemandRequestService.save(saveVo);
        return Msg.success();
    }

}
