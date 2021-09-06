<header class="header">
    <nav class="navbar navbar-expand-lg">
        <div class="search-panel">
            <div class="search-inner d-flex align-items-center justify-content-center">
                <div class="close-btn">Close <i class="fa fa-close"></i></div>
                <form id="searchForm" action="#">
                    <div class="form-group">
                        <input type="search" name="search" placeholder="What are you searching for...">
                        <button type="submit" class="submit">Search</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="container-fluid d-flex align-items-center justify-content-between">
            <div class="navbar-header">
                <!-- Navbar Header--><a href="dashboard" class="navbar-brand">
                <div class="brand-text brand-big visible text-uppercase"><strong
                        class="text-primary">Inwestycje</strong><strong>w kupie</strong></div>
                <div class="brand-text brand-sm"><strong class="text-primary">I</strong><strong>K</strong></div></a>
                <button class="sidebar-toggle"><i class="fa fa-long-arrow-left"></i></button>
            </div>
            
                <!-- Calendar    -->
                <div class="list-inline-item dropdown"><a id="languages" rel="nofollow" data-target="#" href="#"
                                                          data-toggle="dropdown" aria-haspopup="true"
                                                          aria-expanded="false"
                                                          class="nav-link language dropdown-toggle">
                    <span id='date-time'></span>
                    <script>
                        var today = new Date();
                        var date = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
                        var time = today.getHours() + ":" + today.getMinutes();
                        var dateTime = date + ' ' + time;
                        document.getElementById('date-time').innerHTML = dateTime;
                    </script>
                </a>

                    <div aria-labelledby="languages" class="dropdown-menu">
                        <a rel="nofollow" href="adminCalendar" class="dropdown-item">

                            <script>

                                var dt = new Date();
                                var month = dt.getMonth(); // read the current month
                                var monthL = dt.toLocaleString('default', {month: 'long'}); // read the current month
                                document.write(monthL + "<br>");

                                var year = dt.getFullYear(); // read the current year
                                dt = new Date(year, month, 01);//Year , month,date format
                                var first_day = dt.getDay(); //, first day of present month
                                dt.setMonth(month + 1, 0); // Set to next month and one day backward.
                                var last_date = dt.getDate(); // Last date of present month

                                var dy = 1; // day variable for adjustment of starting date.
                                document.write("<table><tr><td>Su</td><td>Mon</td><td>Tue</td><td>Wed</td><td>Thu</td><td>Fri</td><td>Sat</td>");

                                for (i = 0; i <= 41; i++) {
                                    if ((i % 7) == 0) {
                                        document.write("</tr><tr>");
                                    } // if week is over then start a new line
                                    if ((i >= first_day) && (dy <= last_date)) {
                                        document.write("<td>" + dy + "</td>");
                                        dy = dy + 1;
                                    } else {
                                        document.write("<td>*</td>");
                                    } // Blank dates.
                                } // end of for loop

                                document.write("</tr></table>")

                            </script>
                        </a>
                    </div>
                </div>


                <!-- Sidebar Toggle Btn-->

            <div class="right-menu list-inline no-margin-bottom">
                <div class="list-inline-item"><a href="#" class="search-open nav-link">
                    <i class="icon-magnifying-glass-browser"></i></a></div>
                <div class="list-inline-item dropdown"><a id="navbarDropdownMenuLink1" href="#" data-toggle="dropdown"
                                                          aria-haspopup="true" aria-expanded="false"
                                                          class="nav-link messages-toggle"><i
                        class="icon-email"></i><span class="badge dashbg-1">5</span></a>
                    <div aria-labelledby="navbarDropdownMenuLink1" class="dropdown-menu messages"><a href="#"
                                                                                                     class="dropdown-item message d-flex align-items-center">
                        <div class="profile"><img src="img/avatar-3.jpg" alt="..." class="img-fluid">
                            <div class="status online"></div>
                        </div>
                        <div class="content"><strong class="d-block">Nadia Halsey</strong><span class="d-block">lorem ipsum dolor sit amit</span><small
                                class="date d-block">9:30am</small></div>
                    </a><a href="#" class="dropdown-item message d-flex align-items-center">
                        <div class="profile"><img src="img/avatar-2.jpg" alt="..." class="img-fluid">
                            <div class="status away"></div>
                        </div>
                        <div class="content"><strong class="d-block">Peter Ramsy</strong><span class="d-block">lorem ipsum dolor sit amit</span><small
                                class="date d-block">7:40am</small></div>
                    </a><a href="#" class="dropdown-item message d-flex align-items-center">
                        <div class="profile"><img src="img/avatar-1.jpg" alt="..." class="img-fluid">
                            <div class="status busy"></div>
                        </div>
                        <div class="content"><strong class="d-block">Sam Kaheil</strong><span class="d-block">lorem ipsum dolor sit amit</span><small
                                class="date d-block">6:55am</small></div>
                    </a><a href="#" class="dropdown-item message d-flex align-items-center">
                        <div class="profile"><img src="img/avatar-5.jpg" alt="..." class="img-fluid">
                            <div class="status offline"></div>
                        </div>
                        <div class="content"><strong class="d-block">Sara Wood</strong><span class="d-block">lorem ipsum dolor sit amit</span><small
                                class="date d-block">10:30pm</small></div>
                    </a><a href="#" class="dropdown-item text-center message"> <strong>See All Messages <i
                            class="fa fa-angle-right"></i></strong></a></div>
                </div>

                <!-- Megamenu-->
                <div class="list-inline-item dropdown menu-large"><a href="#" data-toggle="dropdown" class="nav-link">Mega
                    <i class="fa fa-ellipsis-v"></i></a>
                    <div class="dropdown-menu megamenu">
                        <div class="row">
                            <div class="col-lg-3 col-md-6"><strong class="text-uppercase">Elements Heading</strong>
                                <ul class="list-unstyled mb-3">
                                    <li><a href="#">Lorem ipsum dolor</a></li>
                                    <li><a href="#">Sed ut perspiciatis</a></li>
                                    <li><a href="#">Voluptatum deleniti</a></li>
                                    <li><a href="#">At vero eos</a></li>
                                    <li><a href="#">Consectetur adipiscing</a></li>
                                    <li><a href="#">Duis aute irure</a></li>
                                    <li><a href="#">Necessitatibus saepe</a></li>
                                    <li><a href="#">Maiores alias</a></li>
                                </ul>
                            </div>
                            <div class="col-lg-3 col-md-6"><strong class="text-uppercase">Elements Heading</strong>
                                <ul class="list-unstyled mb-3">
                                    <li><a href="#">Lorem ipsum dolor</a></li>
                                    <li><a href="#">Sed ut perspiciatis</a></li>
                                    <li><a href="#">Voluptatum deleniti</a></li>
                                    <li><a href="#">At vero eos</a></li>
                                    <li><a href="#">Consectetur adipiscing</a></li>
                                    <li><a href="#">Duis aute irure</a></li>
                                    <li><a href="#">Necessitatibus saepe</a></li>
                                    <li><a href="#">Maiores alias</a></li>
                                </ul>
                            </div>
                            <div class="col-lg-3 col-md-6"><strong class="text-uppercase">Elements Heading</strong>
                                <ul class="list-unstyled mb-3">
                                    <li><a href="#">Lorem ipsum dolor</a></li>
                                    <li><a href="#">Sed ut perspiciatis</a></li>
                                    <li><a href="#">Voluptatum deleniti</a></li>
                                    <li><a href="#">At vero eos</a></li>
                                    <li><a href="#">Consectetur adipiscing</a></li>
                                    <li><a href="#">Duis aute irure</a></li>
                                    <li><a href="#">Necessitatibus saepe</a></li>
                                    <li><a href="#">Maiores alias</a></li>
                                </ul>
                            </div>
                            <div class="col-lg-3 col-md-6"><strong class="text-uppercase">Elements Heading</strong>
                                <ul class="list-unstyled mb-3">
                                    <li><a href="#">Lorem ipsum dolor</a></li>
                                    <li><a href="#">Sed ut perspiciatis</a></li>
                                    <li><a href="#">Voluptatum deleniti</a></li>
                                    <li><a href="#">At vero eos</a></li>
                                    <li><a href="#">Consectetur adipiscing</a></li>
                                    <li><a href="#">Duis aute irure</a></li>
                                    <li><a href="#">Necessitatibus saepe</a></li>
                                    <li><a href="#">Maiores alias</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="row megamenu-buttons text-center">
                            <div class="col-lg-2 col-md-4"><a href="#" class="d-block megamenu-button-link dashbg-1"><i
                                    class="fa fa-clock-o"></i><strong>Demo 1</strong></a></div>
                            <div class="col-lg-2 col-md-4"><a href="#" class="d-block megamenu-button-link dashbg-2"><i
                                    class="fa fa-clock-o"></i><strong>Demo 2</strong></a></div>
                            <div class="col-lg-2 col-md-4"><a href="#" class="d-block megamenu-button-link dashbg-3"><i
                                    class="fa fa-clock-o"></i><strong>Demo 3</strong></a></div>
                            <div class="col-lg-2 col-md-4"><a href="#" class="d-block megamenu-button-link dashbg-4"><i
                                    class="fa fa-clock-o"></i><strong>Demo 4</strong></a></div>
                            <div class="col-lg-2 col-md-4"><a href="#" class="d-block megamenu-button-link bg-danger"><i
                                    class="fa fa-clock-o"></i><strong>Demo 5</strong></a></div>
                            <div class="col-lg-2 col-md-4"><a href="#" class="d-block megamenu-button-link bg-info"><i
                                    class="fa fa-clock-o"></i><strong>Demo 6</strong></a></div>
                        </div>
                    </div>
                </div>
                <!-- Megamenu end     -->
                <!-- Languages dropdown    -->
                <div class="list-inline-item dropdown"><a id="languages" rel="nofollow" data-target="#" href="#"
                                                          data-toggle="dropdown" aria-haspopup="true"
                                                          aria-expanded="false"
                                                          class="nav-link language dropdown-toggle"><img
                        src="img/flags/16/GB.png" alt="English"><span
                        class="d-none d-sm-inline-block">English</span></a>
                    <div aria-labelledby="languages" class="dropdown-menu"><a rel="nofollow" href="#"
                                                                              class="dropdown-item"> <img
                            src="img/flags/16/DE.png" alt="English" class="mr-2"><span>German</span></a><a
                            rel="nofollow" href="#" class="dropdown-item"> <img src="img/flags/16/FR.png" alt="English"
                                                                                class="mr-2"><span>French  </span></a>
                    </div>
                </div>
                <!-- Log out               -->
                <div class="list-inline-item logout">
                    <a id="logout" href="<c:url value="/logout" />" class="nav-link" delete-cookies="JSESSIONID"
                     >Logout <i class="icon-logout"></i></a></div>
            </div>
        </div>
    </nav>
</header>