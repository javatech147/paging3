This is a sample project demonstrating implementation of Paging3 in Android.

Find official documentation here: https://developer.android.com/topic/libraries/architecture/paging/v3-overview

API used for pagination: https://rickandmortyapi.com/api/character?page=1

This project is build in MVVM Architecture using Kotlin(with xml) language.

**Hilt** is used as Dependency injection framework.

**Retrofit** is used for making network requests along with Logging Interceptor.

**Glide** is used to load image and show Rounded image.

Key Components in Paging3 

1. **PagingSource**: Decides when to make next page call and perform actual API call.
2. **LoadParams<Int>** : loadParams.key returns the current page number.
3. **LoadResult** : Success(LoadResult.Page()) or Failure(LoadResult.Error()) callback
4. **Pager** : Perform Page Config and Connects PagingSource
5. **PagingConfig** : PagingConfig(pageSize = 20, maxSize = 100)
6. **PagingDataAdapter** : Special adapter for RecyclerView used for Pagination. Provides feature to add Header and Footer with page using **withLoadStateHeaderAndFooter()** and use **submitData**(lifecycle = lifecycle, pagingData = newList) function to update the list.
7. **LoadStateAdapter** : Display progress loader while loading next page.

**Preview:**

https://github.com/user-attachments/assets/412adea5-6fb4-4796-9cca-d93bb9ca7dd2

