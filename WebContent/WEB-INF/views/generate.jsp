<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Microdata WebParser</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/home/main">Microdata WebParser</a>
            </div>
            <!-- /.navbar-header -->


            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/home/main"><i></i>Back to Home</a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Microdata WebParser</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Information Page
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">

                                  <h1>Select an Action</h1>

                                      <div style="margin-left:30%;">
                                          <form action="webservice" method="POST">
                                        		<input type="hidden" name="type" value="microdata">
                                        		<input type="hidden" name="selection" value="${selection}">
                                        		<br><br>
                                        		<input type="submit" style="width:200px" class="btn btn-outline btn-primary" value="Generate Microdata">
                                        	</form>

                                          <form action="webservice" method="POST">
                                        		<input type="hidden" name="type" value="rdfa">
                                        		<input type="hidden" name="selection" value="${selection}">
                                        		<br><br>
                                        		<input type="submit" style="width:200px" class="btn btn-outline btn-primary" value="Generate RDFa code">
                                        	</form>

                                        	<form action="webservice" method="POST">
                                        		<input type="hidden" name="type" value="jsonld">
                                        		<input type="hidden" name="selection" value="${selection}">
                                        		<br><br>
                                        		<input type="submit" style="width:200px" class="btn btn-outline btn-primary" value="Generate JSON-LD">
                                        	</form>
                                      </div>
                                        </br></br></br>

                                        <div class="alert alert-warning">
                                            Note: Parsing and generating might take a few seconds.
                                        </div>

                                        </br>

                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                <strong>Source 1</strong>: ${source1}
                                            </div>
                                            <!-- /.panel-heading -->
                                            <div class="panel-body">
                                                <div class="table-responsive">
                                                    <table class="table table-striped table-bordered table-hover">
                                                        <thead>
                                                            <tr>
                                                                <th>#</th>
                                                                <th>Property Value</th>

                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td>Name</td>
                                                                <td>${extractedCondition1.get("Name")}</td>

                                                            </tr>
                                                            <tr>
                                                                <td>Keywords</td>
                                                                <td>${extractedCondition1.get("Keywords")}</td>

                                                            </tr>
                                                            <tr>
                                                                <td>Description</td>
                                                                <td>${extractedCondition1.get("Description")}</td>

                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <!-- /.table-responsive -->
                                            </div>
                                            <!-- /.panel-body -->
                                        </div>


      </div>
                                <!-- /.col-lg-6 (nested) -->
                                <div class="col-lg-6">

                                    <h1>Generate Code</h1>

                                    </br>
                                    <div class="well">
                                        <h4>Instructions</h4>
                                        <p>The user can generate compliant code from multiple sources. Based on his selection, the sources related to the Medical Condition will be fetched, parsed and used.</p>
                                    </div>
                                  </br></br>

                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <strong>Source 2</strong>: ${source2}
                                        </div>
                                        <!-- /.panel-heading -->
                                        <div class="panel-body">
                                            <div class="table-responsive">
                                                <table class="table table-striped table-bordered table-hover">
                                                    <thead>
                                                        <tr>
                                                            <th>#</th>
                                                            <th>Property Value</th>

                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td>Alternate Name</td>
                                                            <td>${extractedCondition2.get("Alternate Name")}</td>

                                                        </tr>
                                                        <tr>
                                                            <td>Keywords</td>
                                                            <td>${extractedCondition2.get("Keywords")}</td>

                                                        </tr>
                                                        <tr>
                                                            <td>Pathophysiology</td>
                                                            <td>${extractedCondition2.get("Pathophysiology")}</td>

                                                        </tr>

                                                        <tr>
                                                            <td>Possible Treatment</td>
                                                            <td>${extractedCondition2.get("Treatment")}</td>

                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                            <!-- /.table-responsive -->
                                        </div>
                                        <!-- /.panel-body -->
                                    </div>

                                </div>
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            </br></br>
            <div style="text-align: center">Copyright 2017 Ioannis Gkourtzounis</div>
            </br></br>
        </div>
        <!-- /#page-wrapper -->
			
    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/dist/js/sb-admin-2.js"></script>

</body>

</html>
