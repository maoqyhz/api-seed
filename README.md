# api-seed

![GitHub](https://img.shields.io/github/license/maoqyhz/api-seed)
![](https://img.shields.io/badge/JDK-8%2B-green)
![](https://img.shields.io/badge/Spring%20Boot-2.3.7-green)
![GitHub Repo stars](https://img.shields.io/github/stars/maoqyhz/api-seed?style=social)

## 简介

🌱🚀一个基于Spring Boot & Spring Data JPA的种子项目，用于快速构建中小型API、RESTful API项目。

该种子项目会随着作者开发经验的增加、各类依赖包的更新而进行调整，提高可用性。

## 技术选型

- Spring Boot
- Spring Data JPA
- Druid Spring Boot Starter
- Fastjson
- lombok
- guava

## 工程结构

部分package下无文件，无法显示，故提供完整的工程结构。该结构主要参考了《阿里 Java 开发手册》并加以优化。

```
└─com.example.seed
    ├─common
    │  ├─config
    │  ├─support
    │  └─util
    ├─dao
    │  ├─entity
    │  └─repo
    ├─manager
    ├─service
    │  ├─domain
    │  │  ├─bo
    │  │  ├─dto
    │  │  └─enums
    │  └─impl
    └─web
        ├─controller
        ├─param
        │  └─validation
        │      └─groups
        ├─query
        └─vo
```

## 特征&提供

- 统一响应结果封装
- 统一异常处理
- 统一日志打印
- 统一参数化校验
- etc.

  

