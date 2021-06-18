<header>
    <div class="logo-container">
        <img src="img/logoHeidestip.jpg" alt="Logo">
        <h4 class="logo">Jeugdhuis Heidestip</h4>
    </div>
    <nav>
        <ul class="nav-links">
            <li ${param.hier eq 'Home'?"class = hier":""}><a  class="nav-link" href="LedenServlet?command=home">Home</a></li>
            <li ${param.hier eq 'Zoek lid'?"class = hier":""}><a class="nav-link" href="LedenServlet?command=zoek">Zoek lid</a></li>
            <li ${param.hier eq 'Word lid'?"class = hier":""}><a class="nav-link" href="LedenServlet?command=wordLid">Word lid</a></li>
            <li ${param.hier eq 'Leden'?"class = hier":""}><a class="nav-link" href="LedenServlet?command=leden">Leden</a></li>
            <li ${param.hier eq 'Logboek'?"class = hier":""}><a class="nav-link" href="LedenServlet?command=logboek">Logboek</a></li>
        </ul>
    </nav>
</header>