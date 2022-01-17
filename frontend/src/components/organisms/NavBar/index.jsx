import React from 'react';
import ImgBtn from 'components/molecules/ImgBtn';
import NavBarButton from 'components/molecules/NavBarButton';
import { img } from 'assets/img';
import * as Styled from './style';

export default function NavBar() {
  return (
    <Styled.NavBarContainer>
      <Styled.NavBarButtonContainer>
        <ImgBtn alt={'로고'} width={'158px'} src={img.Logo}></ImgBtn>
        <NavBarButton
          contents={['작품보기', '예술품등록', '작가']}
        ></NavBarButton>
      </Styled.NavBarButtonContainer>
      <Styled.NavBarButtonContainer right>
        <ImgBtn alt={'등록'} width={'20px'} src={img.NavImg}></ImgBtn>
        <ImgBtn alt={'검색'} width={'20px'} src={img.NavSearch}></ImgBtn>
        <ImgBtn
          alt={'장바구니'}
          width={'20px'}
          src={img.NavShoppingList}
        ></ImgBtn>
        <ImgBtn alt={'좋아요'} width={'20px'} src={img.NavLike}></ImgBtn>
        <ImgBtn alt={'알람'} width={'20px'} src={img.NavAlarm}></ImgBtn>

        <NavBarButton contents={['로그인', '로그아웃']}></NavBarButton>
      </Styled.NavBarButtonContainer>
    </Styled.NavBarContainer>
  );
}
