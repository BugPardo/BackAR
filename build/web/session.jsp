
<%@page import="java.util.ArrayList"%>
<b:base title="${initParam.tema}">
    <!--Boostrap-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
   


<style>
    body
    {
        background-color: #bbdefb;
 background-image: url("background.jpg");
    
    }
.demo-layout-transparent {
  //background: url("background.jpg") center / cover;
}
.demo-layout-transparent .mdl-layout__header,
.demo-layout-transparent .mdl-layout__drawer-button {

  color: black;
}

.demo-card-square  
{
    float: left;

 // width: 800px;
  width:800px;
 
  margin-top: 10%;
  margin-left: 10%;
  border: 6px solid green;
  padding: 0px;
}
.demo-card-square .mdl-shadow--2dp {
  width: 512px;
}
.demo-card-square > .mdl-card__title {
  color: black;
  height: 176px;
  background: url('../assets/demos/welcome_card.jpg') center / cover;
}
.demo-card-wide > .mdl-card__supporting-text {
  color: #fff;
}
.mdl-layout-title
{
    color: #FFF;
}

</style>


<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>


<div class="demo-layout-transparent mdl-layout mdl-js-layout">
  <header class="mdl-layout__header mdl-layout__header--transparent">
    <div class="mdl-layout__header-row">
      <span class="mdl-layout-title"> Welcome <strong>${sessionScope.sessionFullname }</strong></span>
    </div>
  </header>
  <div class="mdl-layout__drawer">
    <span class="mdl-card__supporting-text">Options</span>
    <nav class="mdl-navigation">
      <a class="mdl-navigation__link" >Contact</a>
       <form action="${pageContext.request.contextPath}/Home" method="post" >
           <button type="submit" name="Logout" >Logout</button>>
       </form>
    </nav>
  </div>
  <main class="mdl-layout__content">
  </main>
</div>   

    
             
    <div class="demo-card-square mdl-card mdl-shadow--2dp" >
  <div class="mdl-card__title mdl-card--expand">
    <h2 class="mdl-card__title-text">Update</h2>
  </div>
  <div class="mdl-card__supporting-text">
 Please choose a PST file and upload in this option
  </div>
  <div class="mdl-card__actions mdl-card--border">
   <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"  data-toggle="modal" data-target="#uploadfile">
     Upload
    </a>
  </div>
</div>
    
             
    <div class="demo-card-square mdl-card mdl-shadow--2dp" >
  <div class="mdl-card__title mdl-card--expand">
    <h2 class="mdl-card__title-text">Validate</h2>
  </div>
  <div class="mdl-card__supporting-text">
 Run job and validate information uploaded
  </div>
  <div class="mdl-card__actions mdl-card--border">
   <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"  data-toggle="modal" data-target="#modalRegisterForm">
     Open Graphic
    </a>
  </div>
</div>
    
    
             
    <div class="demo-card-square mdl-card mdl-shadow--2dp" >
  <div class="mdl-card__title mdl-card--expand">
    <h2 class="mdl-card__title-text">Display</h2>
  </div>
  <div class="mdl-card__supporting-text">
    Role:M display the status for PST files
  </div>
  <div class="mdl-card__actions mdl-card--border">
    <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"  data-toggle="modal" data-target="#modalRegisterForm">
     Open Graphic
    </a>
  </div>
</div>
    
    
    
    
    
          
          <div class="modal fade" id="modalRegisterForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                              aria-hidden="true">
                              <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                  <div class="modal-header text-center">
                                    <h4 class="modal-title w-100 font-weight-bold">Sign up</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                      <span aria-hidden="true">&times;</span>
                                    </button>
                                  </div>
                                 
                                  </div>
                                  <div class="modal-footer d-flex justify-content-center">
                                    <button class="btn btn-deep-orange">Coming</button>
                                  </div>
                                </div>
                              </div>
                            </div>
                        </div>   
    
                        
                        
             <form action="${pageContext.request.contextPath}/Home" method="post" enctype="multipart/form-data">            
          <div class="modal fade" id="uploadfile" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                              aria-hidden="true">
                              <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                  <div class="modal-header text-center">
                                    <h4 class="modal-title w-100 font-weight-bold">Upload file</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                      <span aria-hidden="true">&times;</span>
                                    </button>
                                  </div>

        <h3> My name is ${databa}</h3>       
                                            
                                            
                                            
                                            
                                  <div class="modal-body mx-3">
                                    <div class="md-form mb-5">
                                      <i class="fas fa-user prefix grey-text"></i>
                                      <input type="text" id="orangeForm-name" class="form-control validate">
                                      <label data-error="wrong" data-success="right" for="orangeForm-name">Your name</label>
                                    </div>
                                    <div class="md-form mb-5">
                                      <i class="fas fa-envelope prefix grey-text"></i>
                                      <input type="email" id="orangeForm-email" class="form-control validate">
                                      <label data-error="wrong" data-success="right" for="orangeForm-email">Your email</label>
                                    </div>
                            
                                        <div id="form1-section">
                                        <form id="upload" action="Home" method="post" enctype="multipart/form-data">
                                        <label for="file"> </label> <input type="file" name="zip"/> 
                                        </form>
                                        </div>

                                  </div>
                                    
                                  <div class="modal-footer d-flex justify-content-center">
                                    <button class="btn btn-deep-orange" >Sign up</button>
                                  </div>
                              </div>
                                </div>
                              </div>
                            </div>
                        </div>       
</b:base>