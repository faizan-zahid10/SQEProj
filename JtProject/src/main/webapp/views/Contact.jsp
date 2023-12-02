<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us - Perishable</title>
</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto"></ul>
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" th:href="@{/}" href="#">CART</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="profileDisplay" >Profile</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="about">About</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="contact">Contact</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" sec:authorize="isAuthenticated()" href="logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container mt-4">
        <div class="jumbotron">
            <h1 class="display-4">Contact Us</h1>
            <p class="lead">Have questions or feedback? We'd love to hear from you!</p>
            <hr class="my-4">
            <p>Please fill out the form below, and we'll get back to you as soon as possible.</p>

            <!-- Updated form with field names -->
            <form>
                <div class="form-group">
                    <label for="name">Your Name</label>
                    <input type="text" class="form-control" id="name" placeholder="Your Name">
                </div>
                <div class="form-group">
                    <label for="email">Your Email</label>
                    <input type="email" class="form-control" id="email" placeholder="Your Email">
                </div>
                <div class="form-group">
                    <label for="message">Your Query</label>
                    <textarea class="form-control" id="message" rows="4" placeholder="Your Query"></textarea>
                </div>
                <div class="form-group">
                    <label for="proofs">Any Proofs or Reference (if any)</label>
                    <input type="text" class="form-control" id="proofs" placeholder="Any Proofs or Reference (if any)">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>

    <!-- Empty script tag for custom JavaScript -->
    <script type="text/javascript">
        // Add your custom JavaScript for the page here
    </script>

</body>
</html>
