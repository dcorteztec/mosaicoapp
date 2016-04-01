 <section id="services">
        <div class="container">
            <div class="box first">
                <div class="row">
                    <div class="col-md-4 col-sm-6">
                        <div class="center">
                            <i class="icon-apple icon-md icon-color1"></i>
                            <h4>iOS development</h4>
                            <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae.</p>
                        </div>
                    </div><!--/.col-md-4-->
                    <div class="col-md-4 col-sm-6">
                        <div class="center">
                            <i class="icon-android icon-md icon-color2"></i>
                            <h4>Android development</h4>
                            <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae.</p>
                        </div>
                    </div><!--/.col-md-4-->
                    <div class="col-md-4 col-sm-6">
                        <div class="center">
                            <i class="icon-windows icon-md icon-color3"></i>
                            <h4>Windows Phone development</h4>
                            <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae.</p>
                        </div>
                    </div><!--/.col-md-4-->
                    <div class="col-md-4 col-sm-6">
                        <div class="center">
                            <i class="icon-html5 icon-md icon-color4"></i>
                            <h4>Ruby on Rails development</h4>
                            <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae.</p>
                        </div>
                    </div><!--/.col-md-4-->
                    <div class="col-md-4 col-sm-6">
                        <div class="center">
                            <i class="icon-css3 icon-md icon-color5"></i>
                            <h4>Javascript development</h4>
                            <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae.</p>
                        </div>
                    </div><!--/.col-md-4-->
                    <div class="col-md-4 col-sm-6">
                        <div class="center">
                            <i class="icon-thumbs-up icon-md icon-color6"></i>
                            <h4>Responsive web design</h4>
                            <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae.</p>
                        </div>
                    </div><!--/.col-md-4-->
                </div><!--/.row-->
            </div><!--/.box-->
        </div><!--/.container-->
    </section><!--/#services-->

    <section id="portfolio">
        <div class="container">
            <div class="box" ng-controller="IndexController as tc">
                <div class="center gap">
                    <h2>Muitos Serviços para sua Festa</h2>
                    <p class="lead">Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac<br>turpis egestas. Vestibulum tortor quam, feugiat vitae.</p>
                </div><!--/.center-->
                <ul class="portfolio-filter" id="filterPort" opt-kind ok-key="filter" >
                    <li><a class="btn btn-primary active" href="#" ok-sel="*">All</a></li>
                    <li ng-repeat="text in tc.tServicos">
                    	<a class="btn btn-primary" href="#" ok-sel=".{{text.nome}}">{{text.nome}}</a>
                   	</li>
                </ul><!--/#portfolio-filter-->
                <ul class="portfolio-items col-4" id="isotopeContainer" isotope-container ng-cloak>
                    <li isotope-item class="portfolio-item {{text.servicos}}" ng-repeat="text in tc.empresas">
                        <div class="item-inner">
                            <div class="portfolio-image">
                                <img src="{{text.urlLogo}}" alt="">
                                <div class="overlay">
                                    <a class="preview btn btn-danger" rel="prettyPhoto" href="{{text.urlLogo}}"><i class="icon-eye-open"></i></a>             
                                </div>
                            </div>
                            <h5>{{text.nome}}</h5>
                        </div>
                    </li><!--/.portfolio-item-->
                    
                </ul>   
            </div><!--/.box-->
        </div><!--/.container-->
    </section><!--/#portfolio-->

    <section id="pricing">
        <div class="container">
            <div class="box">
                <div class="center">
                    <h2>See our Pricings</h2>
                    <p class="lead">Pellentesque habitant morbi tristique senectus et netus et <br>malesuada fames ac turpis egestas.</p>
                </div><!--/.center-->   
                <div class="big-gap"></div>
                <div id="pricing-table" class="row">
                    <div class="col-sm-4">
                        <ul class="plan">
                            <li class="plan-name">Basic</li>
                            <li class="plan-price">$29</li>
                            <li>5GB Storage</li>
                            <li>1GB RAM</li>
                            <li>400GB Bandwidth</li>
                            <li>10 Email Address</li>
                            <li>Forum Support</li>
                            <li class="plan-action"><a href="#" class="btn btn-primary btn-lg">Signup</a></li>
                        </ul>
                    </div><!--/.col-sm-4-->
                    <div class="col-sm-4">
                        <ul class="plan featured">
                            <li class="plan-name">Standard</li>
                            <li class="plan-price">$49</li>
                            <li>10GB Storage</li>
                            <li>2GB RAM</li>
                            <li>1TB Bandwidth</li>
                            <li>100 Email Address</li>
                            <li>Forum Support</li>
                            <li class="plan-action"><a href="#" class="btn btn-primary btn-lg">Signup</a></li>
                        </ul>
                    </div><!--/.col-sm-4-->
                    <div class="col-sm-4">
                        <ul class="plan">
                            <li class="plan-name">Advanced</li>
                            <li class="plan-price">$199</li>
                            <li>30GB Storage</li>
                            <li>5GB RAM</li>
                            <li>5TB Bandwidth</li>
                            <li>1000 Email Address</li>
                            <li>Forum Support</li>
                            <li class="plan-action"><a href="#" class="btn btn-primary btn-lg">Signup</a></li>
                        </ul>
                    </div><!--/.col-sm-4-->
                </div> 
            </div> 
        </div>
    </section><!--/#pricing-->

    <section id="about-us">
        <div class="container">
            <div class="box">
                <div class="center">
                    <h2>Meet the Team</h2>
                    <p class="lead">Pellentesque habitant morbi tristique senectus et netus et<br>malesuada fames ac turpis egestas.</p>
                </div>
                <div class="gap"></div>
                <div id="team-scroller" class="carousel scale">
                    <div class="carousel-inner">
                        <div class="item active">
                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="member">
                                        <p><img class="img-responsive img-thumbnail img-circle" src="images/team1.jpg" alt="" ></p>
                                        <h3>Agnes Smith<small class="designation">CEO &amp; Founder</small></h3>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="member">
                                        <p><img class="img-responsive img-thumbnail img-circle" src="images/team2.jpg" alt="" ></p>
                                        <h3>Donald Ford<small class="designation">Senior Vice President</small></h3>
                                    </div>
                                </div>        
                                <div class="col-sm-4">
                                    <div class="member">
                                        <p><img class="img-responsive img-thumbnail img-circle" src="images/team3.jpg" alt="" ></p>
                                        <h3>Karen Richardson<small class="designation">Assitant Vice President</small></h3>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="member">
                                        <p><img class="img-responsive img-thumbnail img-circle" src="images/team3.jpg" alt="" ></p>
                                        <h3>David Robbins<small class="designation">Co-Founder</small></h3>
                                    </div>
                                </div>   
                                <div class="col-sm-4">
                                    <div class="member">
                                        <p><img class="img-responsive img-thumbnail img-circle" src="images/team1.jpg" alt="" ></p>
                                        <h3>Philip Mejia<small class="designation">Marketing Manager</small></h3>
                                    </div>
                                </div>     
                                <div class="col-sm-4">
                                    <div class="member">
                                        <p><img class="img-responsive img-thumbnail img-circle" src="images/team2.jpg" alt="" ></p>
                                        <h3>Charles Erickson<small class="designation">Support Manager</small></h3>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <a class="left-arrow" href="#team-scroller" data-slide="prev">
                        <i class="icon-angle-left icon-4x"></i>
                    </a>
                    <a class="right-arrow" href="#team-scroller" data-slide="next">
                        <i class="icon-angle-right icon-4x"></i>
                    </a>
                </div><!--/.carousel-->
            </div><!--/.box-->
        </div><!--/.container-->
    </section><!--/#about-us-->