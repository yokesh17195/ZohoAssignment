package com.sample.zoho.ui.userlist

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.zoho.R
import com.sample.zoho.databinding.FragmentUserListBinding
import com.sample.zoho.ui.userlist.adapter.UserListAdapter
import com.sample.zoho.ui.userlist.adapter.UserLoadStateAdapter
import com.sample.zoho.ui.userlist.logic.UserListLogic
import com.sample.zoho.utils.Status
import com.sample.zoho.viewmodel.DataViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UserListFragment : Fragment(R.layout.fragment_user_list) {

    val viewmodel: DataViewModel by activityViewModels()

    @Inject
    lateinit var userListLogic: UserListLogic

    val userListAdapter: UserListAdapter by lazy {
        UserListAdapter()
    }

    lateinit var binding: FragmentUserListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentUserListBinding.bind(view)

        initUI()

        fetchData()


    }

    private fun fetchData() {

        viewmodel.data.observe(viewLifecycleOwner, {
            /*  when(it.status){

                  Status.LOADING->{

                  }
                  Status.SUCCESS->{
                      Log.e("size", userListLogic.getUserList(it.data?.results!!).size.toString())
                      userListAdapter.submitList(userListLogic.getUserList(it.data?.results!!))
                  }
                  Status.ERROR->{

                  }

              }*/
            
            userListAdapter.submitData(viewLifecycleOwner.lifecycle, it)

        })

    }

    private fun initUI() {

        binding.userList.apply {
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
            adapter =
                userListAdapter.withLoadStateHeaderAndFooter(
                    header = UserLoadStateAdapter { userListAdapter.retry() },
                    footer = UserLoadStateAdapter { userListAdapter.retry() })
        }

    }
}