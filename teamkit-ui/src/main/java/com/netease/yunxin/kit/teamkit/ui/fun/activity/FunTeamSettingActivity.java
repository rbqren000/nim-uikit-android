// Copyright (c) 2022 NetEase, Inc. All rights reserved.
// Use of this source code is governed by a MIT license that can be
// found in the LICENSE file.

package com.netease.yunxin.kit.teamkit.ui.fun.activity;

import static com.netease.yunxin.kit.corekit.im.utils.RouterConstant.KEY_TEAM_ID;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.netease.yunxin.kit.chatkit.model.UserInfoWithTeam;
import com.netease.yunxin.kit.corekit.im.utils.RouterConstant;
import com.netease.yunxin.kit.teamkit.ui.R;
import com.netease.yunxin.kit.teamkit.ui.activity.BaseTeamSettingActivity;
import com.netease.yunxin.kit.teamkit.ui.adapter.TeamCommonAdapter;
import com.netease.yunxin.kit.teamkit.ui.databinding.FunTeamSettingActivityBinding;
import com.netease.yunxin.kit.teamkit.ui.databinding.FunTeamSettingUserItemBinding;
import com.netease.yunxin.kit.teamkit.ui.fun.adapter.FunTeamSettingMemberAdapter;

/** team setting activity */
public class FunTeamSettingActivity extends BaseTeamSettingActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    changeStatusBarColor(R.color.color_white);
  }

  @Override
  protected View initViewAndGetRootView(Bundle savedInstanceState) {
    FunTeamSettingActivityBinding binding =
        FunTeamSettingActivityBinding.inflate(getLayoutInflater());
    bg3 = binding.bg3;
    ivIcon = binding.ivIcon;
    tvName = binding.tvName;
    tvHistory = binding.tvHistory;
    tvMark = binding.tvMark;
    tvCount = binding.tvCount;
    tvMember = binding.tvMember;
    tvQuit = binding.tvQuit;
    tvTeamNickname = binding.tvTeamNickname;
    tvTeamManager = binding.tvManager;
    nicknameGroup = binding.nicknameGroup;
    teamMuteGroup = binding.teamMuteGroup;
    swStickTop = binding.swSessionStick;
    swMessageTip = binding.swMessageTip;
    swTeamMute = binding.swTeamMute;
    ivBack = binding.ivBack;
    ivAdd = binding.ivAdd;
    rvMemberList = binding.rvMemberList;
    return binding.getRoot();
  }

  @Override
  protected TeamCommonAdapter<UserInfoWithTeam, ?> getTeamMemberAdapter() {
    return new FunTeamSettingMemberAdapter(this, FunTeamSettingUserItemBinding.class);
  }

  protected String getContactSelectorRouterPath() {
    return RouterConstant.PATH_FUN_CONTACT_SELECTOR_PAGE;
  }

  protected String getPinRouterPath() {
    return RouterConstant.PATH_FUN_CHAT_PIN_PAGE;
  }

  protected String getHistoryRouterPath() {
    return RouterConstant.PATH_FUN_CHAT_SEARCH_PAGE;
  }

  protected Class<? extends Activity> getUpdateNickNameActivity() {
    return FunTeamUpdateNicknameActivity.class;
  }

  protected Class<? extends Activity> getTeamMemberListActivity() {
    return FunTeamMemberListActivity.class;
  }

  protected Class<? extends Activity> getTeamInfoActivity() {
    return FunTeamInfoActivity.class;
  }

  @Override
  protected void toManagerPage() {
    Intent intent = new Intent(this, FunTeamManagerActivity.class);
    intent.putExtra(KEY_TEAM_ID, teamId);
    startActivity(intent);
  }
}
