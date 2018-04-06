//package test.checks.controllers;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;

public class CheckByFundForCashbookController
{
    @Binding
    def binding;
    
    @Service("TestchequedataentryReportService")
    def svc;   
    
    def searchtext;
    
    def entity;
    
    String title = 'List of Checks';
    def selectedCheckitem;
    def checkHandler = [
        fetchList : {
            
            it.searchtext = searchtext;
            svc.getCheckList(it) },
        
        onCommitItem : {
                    if(! MsgBox.confirm("Please make sure the information is correct. Continue? ")) return;
                        
                        svc.updateVoucher(it)
                       // selectedCheckitem.voucherno << entity.voucherno;
                       // isnew : true /////addCouponValidation
                   // if(! svc.voucherValidation(it)) {
                     //   MsgBox.alert("Info already exists!")
                     //   it.voucherno = "";
                   // }
                               
                }
                
    ] as EditorListModel; //other type: BasicListModel
    
    public void search(){
        checkHandler.reload();
        
    }
    
  //  public def create(){
  //      return Inv.lookupOpener('payorder:create');
  //  }
    
   // public def open(){
     //   return Inv.lookupOpener('payorder:open', [entity:selectedSGAdminPayorderitem]);
   // }
    
  //  public void delete(){
  //      if (MsgBox.confirm('Delete Item?')){
  //          if(MsgBox.confirm('Are you sure?')){
  //              if(MsgBox.confirm('Are you really sure?')){
  //                  svc.delete(selectedItem);
 //                   listHandler.reload();
  //              }
                
  //          }
            
   //     }
        
  //  }
    
    
    
}
