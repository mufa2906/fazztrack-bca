# API DailyNews

Repository untuk REST API Library App  

## How to Run

Untuk menjalankannya, clone dan jalankan perintah berikut:
```mvnw spring-boot:run```

## List of Service Methods

- User:
  - **Sign Up**: POST - <http://localhost:9090/users/register>
  - **Sign In**: POST - <http://localhost:9090/users/login>
  - **Forgot Pass**: POST - <http://localhost:9090/users/forgot-password>
  - **Update User**: POST - <http://localhost:9090/users/{username}/update>
  - **Delete User**: POST - <http://localhost:9090/users/{username}/delete>
  - **Get All User**: GET - <http://localhost:9090/users>
  - **Get User**: GET - <http://localhost:9090/users/{username}>
- Article:
  - **Create Article**: POST - <http://localhost:9090/articles/create>
  - **Update Article**: POST - <http://localhost:9090/{id}/update>
  - **Validate Article**: PUT - <http://localhost:9090/admin/{id}/valid>
  - **Get All Article**: GET - <http://localhost:9090/articles>
  - **Get Article By Trending**: GET - <http://localhost:9090/articles/trending>
  - **Get Article By Latest**: GET - <http://localhost:9090/articles/latest>
  - **Get Article By Popular**: GET - <http://localhost:9090/articles/popular>
  - **Get Article By Recommended**: GET - <http://localhost:9090/articles/recommended>
  - **Get Article By Id**: GET - <http://localhost:9090/articles/{id}>
- Article Comment:
  - **Add Article Comment**: POST - <http://localhost:9090/articles/{id}/comment/create>
  - **Get Article Comment By Article**: GET - <http://localhost:9090/article/{id}/comments>
  - **Get Article Comment**: GET - <http://localhost:9090/admin/article-comments>
- Article Wishlist:
  - **Add Article Wishlist**: POST - <http://localhost:9090/article-wishlist/create>
  - **Get Article Wishlist By User**: GET - <http://localhost:9090/article-wishlist/{id}>
  - **Get Article Wishlist**: GET - <http://localhost:9090/admin/article-wishlist>
- Article Types
  - **Add Article Types**: POST - <http://localhost:9090/admin/article-types>
  - **Delete Article Types**: POST - <http://localhost:9090/admin/article-types/delete?type="?">
  - **Get Article Types**: GET - <http://localhost:9090/admin/article-types>
- Image Storage
  - **Add Image File**: POST - <http://localhost:9090/files/article>
  - **Delete Image File**: POST - <http://localhost:9090/files/article/delete>
  - **Load Image File**: GET - <http://localhost:9090/files/article/{id}>
  - **Load All Image File**: GET - <http://localhost:9090/files/article>
- Roles
  - **Add Roles**: POST - <http://localhost:9090/admin/roles>
  - **Delete Roles**: POST - <http://localhost:9090/admin/roles/delete?name="?">
  - **Get Roles**: GET - <http://localhost:9090/admin/roles>

## Documentation API Online

For complete documentation REST API and example request body, can access to this link: **<https://documenter.getpostman.com/view/19462538/2s9YBz3vNZ>**

## Happy Coding~
