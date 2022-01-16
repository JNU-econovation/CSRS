import React from 'react';

import * as S from './style';
import ImgBtn from 'components/molecules/ImgBtn';
import { CATEGORIES } from 'common/constants/string';

const bigCategoryIdx = [2, 5];

function CategoryGrid() {
  function CategoryList(props) {
    const categories = props.categories;
    const listItems = categories.map((category, idx) => {
      const link = category.name.toLowerCase().split(' ').join('');
      const Btn = (
        <ImgBtn
          to={`/art/${link}`}
          key={link}
          src={category.img}
          category={category.name}
        ></ImgBtn>
      );
      if (bigCategoryIdx.includes(idx)) {
        return <S.BigItem>{Btn}</S.BigItem>;
      }
      return Btn;
    });
    return listItems;
  }

  return (
    <S.CateogryContainer>
      <CategoryList categories={CATEGORIES}></CategoryList>
    </S.CateogryContainer>
  );
}

export default CategoryGrid;
