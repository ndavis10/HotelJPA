/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 $(document).ready(function(){
      $('.materialboxed').materialbox();
      $('select').material_select();
      $('#wizard').change(function(){
         var wizardValue = $('#wizard').val();
         switch(wizardValue)
         {
             case '0':
                 $('.stateInput').hide();
                 $('.cityInput').hide();
                 break;
             case '1':
                 $('.stateInput').show();
                 $('.cityInput').hide();
                 break;
             case '2':
                 $('.stateInput').hide();
                 $('.cityInput').show();
                 break;
         }
      });
    });
