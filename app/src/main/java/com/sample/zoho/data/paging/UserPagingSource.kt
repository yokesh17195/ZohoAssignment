package com.sample.zoho.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sample.zoho.data.responsemodels.Results
import com.sample.zoho.data.responsemodels.UserResponseModel
import com.sample.zoho.data.webservice.UserWebService
import retrofit2.HttpException
import java.io.IOException

class UserPagingSource(private val userWebService: UserWebService) :
    PagingSource<Int, Results>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Results> {
        val position = params.key ?: 1



        return try {
            val response = userWebService.getDataResponse()
            val users = response.results

            LoadResult.Page(
                data = users,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (users.isEmpty()) null else position + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Results>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}