<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="modal-body" ng-controller="AcervoController as ctrl" 
    ng-swipe-left="Lightbox.nextImage()"
    ng-swipe-right="Lightbox.prevImage()"
    >
<form ng-submit="ctrl.submit()" name="myForm"
							class="form-horizontal">
  <!-- image -->
  <div class="lightbox-image-container">
    <img lightbox-src="{{Lightbox.imageUrl}}">
  </div>

 <!-- button -->
  <div style="text-align: center;">
       <button type="button" ng-click="ctrl.remove(Lightbox.image.id)" class="btn btn-danger custom-width" ><spring:message code="campo.remover"/></button>
  </div>
</form>
</div>