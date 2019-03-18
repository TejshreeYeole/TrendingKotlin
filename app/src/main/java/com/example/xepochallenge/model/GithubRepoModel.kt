package com.example.xepochallenge.model

data class GithubRepoModel(
    val author: String,
    val builtBy: List<BuiltBy>,
    val currentPeriodStars: Int,
    val description: String,
    val forks: Int,
    val language: String,
    val languageColor: String,
    val name: String,
    val stars: Int,
    val url: String
)

data class BuiltBy(
    val avatar: String,
    val href: String,
    val username: String
)